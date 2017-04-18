import   java.awt.event.ItemEvent;   
import   java.awt.event.ItemListener;   
import   java.awt.event.KeyEvent;   
import   java.awt.event.KeyListener;   
import   java.util.List;   
import   java.util.Vector;   
import   javax.swing.ComboBoxModel;   
import   javax.swing.DefaultComboBoxModel;   
import   javax.swing.JComboBox;      
import   javax.swing.JTextField;   

public   class   JAutoCompleteComboBox   extends   JComboBox   {   
        private   AutoCompleter   completer; 

        public   JAutoCompleteComboBox() 
        { 
                super(); 
                addCompleter(); 
        } 

        public   JAutoCompleteComboBox(ComboBoxModel   cm)   { 
                super(cm); 
                addCompleter(); 
        } 
        
        public   JAutoCompleteComboBox(Object[]   items)   { 
                super(items); 
                addCompleter(); 
        } 


        private   void   addCompleter()   { 
                setEditable(true); 
                completer   =   new   AutoCompleter(this); 
        } 

        public   void   autoComplete(String   str)   { 
                this.completer.autoComplete(str,str.length()); 
        } 

        public   String   getText()   { 
                return   ((JTextField)   getEditor().getEditorComponent()).getText(); 
        } 

        public   void   setText(String   text)   { 
                ((JTextField)   getEditor().getEditorComponent()).setText(text); 
        } 

        public   boolean   containsItem(String   itemString) 
        { 
                for   (int   i   =   0;   i   <   this.getModel().getSize();   i++)   { 
                        String   _item   =   " "   +   this.getModel().getElementAt(i); 
                        if   (_item.equals(itemString)) 
                                return   true; 
                } 
                return   false; 
        } 
        
}   
  
/**   
  *   自动完成器。自动找到最匹配的项目，并排在列表的最前面。 
  *   
  *   @author   Turbo   Chen 
  */ 

class   AutoCompleter   implements   KeyListener,   ItemListener   {   

        private   JComboBox   owner   =   null; 
        private   JTextField   editor   =   null; 
        private   ComboBoxModel   model   =   null;   

        public   AutoCompleter(JComboBox   comboBox) 
        { 
                owner   =   comboBox; 
                editor   =   (JTextField)   comboBox.getEditor().getEditorComponent(); 
                editor.addKeyListener(this); 
                model   =   comboBox.getModel();   
                owner.addItemListener(this); 
        } 
        
        public   void   keyTyped(KeyEvent   e)   {   } 

        public   void   keyPressed(KeyEvent   e)   {   } 

        public   void   keyReleased(KeyEvent   e) 
        { 
                char   ch   =   e.getKeyChar(); 
                if   (ch   ==   KeyEvent.CHAR_UNDEFINED||Character.isISOControl(ch)||ch   ==   KeyEvent.VK_DELETE) 
                        return; 

                int   caretPosition   =   editor.getCaretPosition(); 
                String   str   =   editor.getText(); 
                if   (str.length()   ==   0) 
                return;
                if (isEnglishOrNumber(str.charAt(0)) == true)
                	return;
//                if (isChinese(str) == false)
//                	return;
                autoComplete(str,   caretPosition); 
        } 
        
        private static boolean isChinese(char c) {
    		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
    		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
    				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
    				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
    				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
    				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
    				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
    				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
    			return true;
    		}
    		return false;
    	}
        
        private static boolean isEnglishOrNumber(char c) {
        	if ((c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<= '9'))
        		return true;
    		return false;
    	}
        
    	public static boolean isChinese(String strName) {
    		char[] ch = strName.toCharArray();
    		for (int i = 0; i < ch.length; i++) {
    			char c = ch[i];
    			if (isChinese(c)) {
    				return true;
    			}
    		}
    		return false;
    	}
        
        /** 
          *   自动完成。根据输入的内容，在列表中找到相似的项目. 
          */ 
        protected   void   autoComplete(String   strf,   int   caretPosition) 
        { 
                Object[]   opts; 
                opts   =   getMatchingOptions(strf.substring(0,   caretPosition)); 
                if   (owner   !=   null && opts[0].toString().startsWith(strf.substring(0,   caretPosition)))   { //逻辑
                model   =   new   DefaultComboBoxModel(opts); 
                        owner.setModel(model); 
                } 
                if   (opts.length   >   0)   { 
                        String   str   =   opts[0].toString(); 
                        editor.setCaretPosition(caretPosition); 
                        if   (owner   !=   null)   { 
                                try   { 
                                        owner.showPopup(); 
                                }   catch   (Exception   ex)   { 
                                        ex.printStackTrace(); 
                                } 
                        } 
                } 
        } 
        
        /** 
          *   
          *   找到相似的项目,   并且将之排列到数组的最前面。 
          *   @param   str   
          *   @return   返回所有项目的列表。 
          */ 
        protected   Object[]   getMatchingOptions(String   str) 
        { 
                List   v   =   new   Vector(); 
                List   v1   =   new   Vector(); 
                
                for   (int   k   =   0;   k   <   model.getSize();   k++)   { 
                        Object   itemObj   =   model.getElementAt(k); 
                        if   (   itemObj!=null   )   { 
                                String   item   =   itemObj.toString(); 
                                if   (item.startsWith(str)) 
                                        v.add(model.getElementAt(k)); 
                                else 
                                        v1.add(model.getElementAt(k)); 
                        }else 
                                v1.add(model.getElementAt(k)); 
                } 
                for   (int   i   =   0;   i   <   v1.size();   i++)   { 
                        v.add(v1.get(i)); 
                } 
                if   (v.isEmpty()) 
                        v.add(str); 
                return   v.toArray(); 
        } 
        public   void   itemStateChanged(ItemEvent   event) 
        { 
                if   (event.getStateChange()   ==   ItemEvent.SELECTED) 
                { 
                        int   caretPosition   =   editor.getCaretPosition(); 
                        if   (caretPosition   !=   -1)   { 
                                try   { 
                                        editor.moveCaretPosition(caretPosition); 
                                }   catch   (IllegalArgumentException   ex)   { 
                                        ex.printStackTrace(); 
                                } 
                        } 
                } 
        } 
}  