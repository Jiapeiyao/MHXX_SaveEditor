
import javax.swing.JOptionPane;

public class talisman {
	final range noRange = new range(0, 0);
	public singleSkillInfo[] skill1LimitTable = new singleSkillInfo[206]; //new one
	public singleSkillInfo[] skill2LimitTable = new singleSkillInfo[206]; //new one
	public int selectedTalismanRarityType = 0; //1,2,3,4	
	
	private String kiranico_skill_limits = "无,スキル ,,,,,,スキル ,,,,,\n"
			+ "毒,スキル ,+1 ～ +5,+1 ～ +5,,,,スキル ,,-10 ～ +7,,,\n"
			+ "麻痹,スキル ,+1 ～ +5,+1 ～ +5,,,,スキル ,,-10 ～ +7,,,\n"
			+ "睡眠,スキル ,+1 ～ +5,+1 ～ +5,,,,スキル ,,-10 ～ +7,,,\n"
			+ "气绝,スキル ,+1 ～ +8,+1 ～ +8,,,,スキル ,,-10 ～ +10,-10 ～ +13,,\n"
			+ "听觉保护,スキル ,,,+1 ～ +5,+3 ～ +7,,スキル ,,,-3 ～ +3,-3 ～ +5,\n"
			+ "风压,スキル ,,+1 ～ +4,+1 ～ +5,+5 ～ +10,,スキル ,,,-10 ～ +3,-5 ～ +7,\n"
			+ "耐震,スキル ,+1 ～ +7,+1 ～ +7,,,,スキル ,,-10 ～ +8,,,\n"
			+ "だるま,スキル ,+1 ～ +7,+1 ～ +7,,,,スキル ,,-10 ～ +8,,,\n"
			+ "耐暑,スキル ,+1 ～ +10,,,,,スキル ,,-10 ～ +10,,,\n"
			+ "耐寒,スキル ,+1 ～ +10,,,,,スキル ,,-10 ～ +10,,,\n"
			+ "寒冷适应,スキル ,,,+1 ～ +5,+3 ～ +7,,スキル ,,,,,\n"
			+ "炎热适应,スキル ,,,+1 ～ +5,+3 ～ +7,,スキル ,,,,,\n"
			+ "盗窃无效,スキル ,+1 ～ +10,,,,,スキル ,,-10 ～ +10,,,\n"
			+ "对防御DOWN,スキル ,+1 ～ +7,+1 ～ +7,,,,スキル ,,-10 ～ +8,,,\n"
			+ "狂击耐性,スキル ,+1 ～ +3,,+1 ～ +5,+3 ～ +7,,スキル ,,-5 ～ +5,,,\n"
			+ "細菌学,スキル ,,,+1 ～ +8,+5 ～ +10,,スキル ,,-5 ～ +5,,,\n"
			+ "裂傷,スキル ,+1 ～ +5,,,,,スキル ,,-10 ～ +10,,,\n"
			+ "攻击,スキル ,+1 ～ +4,+1 ～ +4,,,,スキル ,,-7 ～ +7,-10 ～ +10,-7 ～ +10,\n"
			+ "防御,スキル ,+1 ～ +4,+1 ～ +4,,,,スキル ,,-7 ～ +7,-10 ～ +10,-5 ～ +13,\n"
			+ "体力,スキル ,+1 ～ +8,+1 ～ +8,,,,スキル ,,-10 ～ +10,-10 ～ +13,,\n"
			+ "火耐性,スキル ,+1 ～ +6,+1 ～ +6,,,,スキル ,,-10 ～ +10,-10 ～ +13,,\n"
			+ "水耐性,スキル ,+1 ～ +6,+1 ～ +6,,,,スキル ,,-10 ～ +10,-10 ～ +13,,\n"
			+ "雷耐性,スキル ,+1 ～ +6,+1 ～ +6,,,,スキル ,,-10 ～ +10,-10 ～ +13,,\n"
			+ "冰耐性,スキル ,+1 ～ +6,+1 ～ +6,,,,スキル ,,-10 ～ +10,-10 ～ +13,,\n"
			+ "龙耐性,スキル ,+1 ～ +6,+1 ～ +6,,,,スキル ,,-10 ～ +10,-10 ～ +13,,\n"
			+ "属性耐性,スキル ,,,+1 ～ +5,+3 ～ +7,,スキル ,,,-3 ～ +3,-5 ～ +7,\n"
			+ "火属性攻撃,スキル ,,+1 ～ +7,+1 ～ +7,,,スキル ,,,-10 ～ +13,-5 ～ +13,\n"
			+ "水属性攻撃,スキル ,,+1 ～ +7,+1 ～ +7,,,スキル ,,,-10 ～ +13,-5 ～ +13,\n"
			+ "雷属性攻撃,スキル ,,+1 ～ +7,+1 ～ +7,,,スキル ,,,-10 ～ +13,-5 ～ +13,\n"
			+ "冰属性攻撃,スキル ,,+1 ～ +7,+1 ～ +7,,,スキル ,,,-10 ～ +13,-5 ～ +13,\n"
			+ "龙属性攻撃,スキル ,,+1 ～ +7,+1 ～ +7,,,スキル ,,,-10 ～ +13,-5 ～ +13,\n"
			+ "属性攻撃,スキル ,,,+1 ～ +5,+3 ～ +7,,スキル ,,,,,\n"
			+ "特殊攻撃,スキル ,,+1 ～ +4,+1 ～ +6,+3 ～ +7,,スキル ,,-4 ～ +4,-10 ～ +4,-5 ～ +7,\n"
			+ "研ぎ師,スキル ,,+1 ～ +4,,,,スキル ,,,-10 ～ +8,-7 ～ +10,\n"
			+ "匠,スキル ,,,,,,スキル ,,,-5 ～ +5,-3 ～ +5,\n"
			+ "斩味,スキル ,,,+1 ～ +5,+3 ～ +7,,スキル ,,,-3 ～ +3,-5 ～ +7,\n"
			+ "剑術,スキル ,,,+1 ～ +5,+3 ～ +7,,スキル ,,,-3 ～ +3,-5 ～ +7,\n"
			+ "研磨術,スキル ,,,,+1 ～ +5,,スキル ,,,-3 ～ +3,-3 ～ +5,\n"
			+ "钝器,スキル ,,+1 ～ +4,+1 ～ +6,+2 ～ +6,,スキル ,,,,,\n"
			+ "拔刀会心,スキル ,,,,+1 ～ +5,,スキル ,,,-3 ～ +3,-5 ～ +5,\n"
			+ "拔刀減気,スキル ,,,,+1 ～ +5,,スキル ,,-5 ～ +5,-5 ～ +8,-2 ～ +8,\n"
			+ "纳刀,スキル ,,+1 ～ +6,+1 ～ +6,+5 ～ +10,,スキル ,,,-10 ～ +4,-5 ～ +7,\n"
			+ "纳刀研磨,スキル ,,,+1 ～ +6,+5 ～ +10,,スキル ,,,-3 ～ +3,,\n"
			+ "刃鱗,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "装填速度,スキル ,,+1 ～ +4,+1 ～ +6,+3 ～ +7,,スキル ,,,-3 ～ +4,-5 ～ +7,\n"
			+ "反動,スキル ,,,+1 ～ +5,+2 ～ +6,,スキル ,,,-3 ～ +3,-5 ～ +7,\n"
			+ "精密射撃,スキル ,+1 ～ +6,+1 ～ +6,,,,スキル ,,-10 ～ +10,,,\n"
			+ "通常弾強化,スキル ,,,+1 ～ +5,+2 ～ +6,,スキル ,,,-3 ～ +3,-3 ～ +5,\n"
			+ "贯通弾強化,スキル ,,,+1 ～ +5,+2 ～ +6,,スキル ,,,-3 ～ +3,-3 ～ +5,\n"
			+ "散弾強化,スキル ,,,+1 ～ +5,+2 ～ +6,,スキル ,,,-3 ～ +3,-3 ～ +5,\n"
			+ "重撃弾強化,スキル ,,,+1 ～ +5,+2 ～ +6,,スキル ,,,-3 ～ +3,-3 ～ +5,\n"
			+ "通常弾追加,スキル ,+1 ～ +8,+1 ～ +6,,,,スキル ,,-8 ～ +8,,,\n"
			+ "贯通弾追加,スキル ,+1 ～ +8,+1 ～ +10,,,,スキル ,,-10 ～ +10,,,\n"
			+ "散弾追加,スキル ,+1 ～ +8,+1 ～ +10,,,,スキル ,,-10 ～ +10,,,\n"
			+ "榴弾追加,スキル ,+1 ～ +8,+1 ～ +10,,,,スキル ,,-10 ～ +10,,,\n"
			+ "扩散弾追加,スキル ,+1 ～ +8,+1 ～ +10,,,,スキル ,,-10 ～ +10,,,\n"
			+ "毒瓶追加,スキル ,+1 ～ +8,,,,,スキル ,,-10 ～ +10,,,\n"
			+ "麻痺瓶追加,スキル ,+1 ～ +8,,,,,スキル ,,-10 ～ +10,,,\n"
			+ "睡眠瓶追加,スキル ,+1 ～ +8,,,,,スキル ,,-10 ～ +10,,,\n"
			+ "强击瓶追加,スキル ,+1 ～ +8,,,,,スキル ,,-10 ～ +12,,,\n"
			+ "属強瓶追加,スキル ,+1 ～ +8,,,,,スキル ,,-10 ～ +12,,,\n"
			+ "接击瓶追加,スキル ,+1 ～ +8,,,,,スキル ,,-10 ～ +10,,,\n"
			+ "减气瓶追加,スキル ,+1 ～ +8,+1 ～ +10,,,,スキル ,,-10 ～ +10,,,\n"
			+ "爆破瓶追加,スキル ,+1 ～ +8,+1 ～ +10,,,,スキル ,,-10 ～ +10,,,\n"
			+ "速射,スキル ,,,,+1 ～ +5,,スキル ,,,-3 ～ +3,-3 ～ +5,\n"
			+ "射法,スキル ,,,+1 ～ +3,+1 ～ +5,,スキル ,,-3 ～ +3,-5 ～ +5,-3 ～ +5,\n"
			+ "装填数,スキル ,,,,+1 ～ +5,,スキル ,,,-3 ～ +3,-3 ～ +5,\n"
			+ "变則射撃,スキル ,+1 ～ +5,,,,,スキル ,,-10 ～ +10,,,\n"
			+ "弹薬節約,スキル ,,+1 ～ +3,+1 ～ +5,+3 ～ +7,,スキル ,,-5 ～ +5,-5 ～ +5,-5 ～ +7,\n"
			+ "达人,スキル ,+1 ～ +4,+1 ～ +4,,,,スキル ,,-7 ～ +7,-10 ～ +10,-7 ～ +10,\n"
			+ "痛撃,スキル ,,,+1 ～ +5,+2 ～ +6,,スキル ,,,-3 ～ +3,-3 ～ +5,\n"
			+ "连撃,スキル ,,,,+1 ～ +5,,スキル ,,,-3 ～ +3,-1 ～ +3,\n"
			+ "特殊会心,スキル ,,+1 ～ +3,+1 ～ +5,+2 ～ +6,,スキル ,,-5 ～ +5,,,\n"
			+ "属性会心,スキル ,,+1 ～ +3,+1 ～ +5,+2 ～ +6,,スキル ,,-5 ～ +5,,,\n"
			+ "会心強化,スキル ,,,,,,スキル ,,,-3 ～ +3,-3 ～ +5,\n"
			+ "里会心,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "蓄力短縮,スキル ,,,+1 ～ +5,+2 ～ +6,,スキル ,,,-3 ～ +3,-3 ～ +5,\n"
			+ "スタミナ,スキル ,,,+1 ～ +5,+2 ～ +6,,スキル ,,,-3 ～ +3,-3 ～ +5,\n"
			+ "体术,スキル ,,+1 ～ +6,+1 ～ +6,+3 ～ +7,,スキル ,,,-3 ～ +4,-3 ～ +5,\n"
			+ "气力回復,スキル ,,+1 ～ +6,+1 ～ +6,+3 ～ +7,,スキル ,,,-3 ～ +4,-3 ～ +5,\n"
			+ "走行継続,スキル ,,,,+2 ～ +6,,スキル ,,,-5 ～ +5,-3 ～ +5,\n"
			+ "回避性能,スキル ,,+1 ～ +6,+1 ～ +6,+2 ～ +6,,スキル ,,,-3 ～ +4,-3 ～ +5,\n"
			+ "回避距離,スキル ,,,+1 ～ +6,+2 ～ +6,,スキル ,,,-3 ～ +4,-3 ～ +5,\n"
			+ "泡沫,スキル ,,,,+1 ～ +5,,スキル ,,,-3 ～ +3,-1 ～ +3,\n"
			+ "防御性能,スキル ,,+1 ～ +6,+1 ～ +6,+3 ～ +7,,スキル ,,,-3 ～ +4,-3 ～ +5,\n"
			+ "防御強化,スキル ,,+1 ～ +4,+1 ～ +6,+3 ～ +7,,スキル ,,,-3 ～ +4,-3 ～ +5,\n"
			+ "KO,スキル ,,+1 ～ +6,+1 ～ +6,+5 ～ +10,,スキル ,,,-3 ～ +4,-7 ～ +10,\n"
			+ "减气攻撃,スキル ,,+1 ～ +6,+1 ～ +6,+5 ～ +10,,スキル ,,,-3 ～ +4,-7 ～ +10,\n"
			+ "笛,スキル ,+1 ～ +6,+1 ～ +6,,,,スキル ,,-8 ～ +8,-10 ～ +10,-5 ～ +10,\n"
			+ "砲術,スキル ,+1 ～ +6,+1 ～ +6,,,,スキル ,,-8 ～ +8,-10 ～ +10,-5 ～ +10,\n"
			+ "重撃,スキル ,,,+1 ～ +5,+2 ～ +6,,スキル ,,,-3 ～ +3,-3 ～ +5,\n"
			+ "爆弾強化,スキル ,+1 ～ +6,+1 ～ +6,,,,スキル ,,-8 ～ +8,-10 ～ +10,-5 ～ +10,\n"
			+ "本気,スキル ,,,+1 ～ +6,+2 ～ +6,,スキル ,,,-3 ～ +4,-3 ～ +5,\n"
			+ "斗魂,スキル ,,,,+1 ～ +5,,スキル ,,,-3 ～ +3,-1 ～ +3,\n"
			+ "无伤,スキル ,,,,+1 ～ +5,,スキル ,,,-3 ～ +3,-1 ～ +3,\n"
			+ "チャンス,スキル ,,,,+1 ～ +5,,スキル ,,,-3 ～ +3,-1 ～ +3,\n"
			+ "龙气,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "底力,スキル ,,+1 ～ +6,+1 ～ +6,+2 ～ +6,,スキル ,,,-3 ～ +4,-3 ～ +5,\n"
			+ "逆境,スキル ,+1 ～ +4,+1 ～ +5,,,,スキル ,,-5 ～ +5,,,\n"
			+ "逆上,スキル ,,+1 ～ +3,+1 ～ +5,+2 ～ +6,,スキル ,,-5 ～ +5,-5 ～ +5,-3 ～ +5,\n"
			+ "窮地,スキル ,,+1 ～ +3,+1 ～ +5,+2 ～ +6,,スキル ,,-5 ～ +5,-5 ～ +5,-3 ～ +5,\n"
			+ "根性,スキル ,,,,+1 ～ +5,,スキル ,,,-3 ～ +3,-1 ～ +3,\n"
			+ "气配,スキル ,+1 ～ +8,,,,,スキル ,,-10 ～ +10,,,\n"
			+ "采配,スキル ,+1 ～ +3,+1 ～ +5,+1 ～ +7,,,スキル ,,-7 ～ +7,-10 ～ +10,,\n"
			+ "号令,スキル ,+1 ～ +3,+1 ～ +5,+1 ～ +7,,,スキル ,,-7 ～ +7,-10 ～ +10,,\n"
			+ "乗り,スキル ,+1 ～ +10,,,,,スキル ,,-8 ～ +8,-5 ～ +5,-7 ～ +10,\n"
			+ "跳躍,スキル ,,+1 ～ +3,+1 ～ +5,+2 ～ +6,,スキル ,,-5 ～ +5,-5 ～ +5,-3 ～ +5,\n"
			+ "無心,スキル ,,,,+1 ～ +5,,スキル ,,,-3 ～ +3,-1 ～ +3,\n"
			+ "我慢,スキル ,,+1 ～ +3,+1 ～ +5,+3 ～ +7,,スキル ,,-5 ～ +5,-5 ～ +5,-5 ～ +7,\n"
			+ "ＳＰ延長,スキル ,,+1 ～ +6,+1 ～ +6,+3 ～ +7,,スキル ,,,-3 ～ +3,-5 ～ +7,\n"
			+ "千里眼,スキル ,+1 ～ +8,+1 ～ +8,,,,スキル ,,-10 ～ +10,-10 ～ +12,,\n"
			+ "观察眼,スキル ,+1 ～ +8,,,,,スキル ,,-10 ～ +10,,,\n"
			+ "狩人,スキル ,+1 ～ +8,,,,,スキル ,,-10 ～ +10,,,\n"
			+ "运搬,スキル ,+1 ～ +8,+1 ～ +8,,,,スキル ,,-10 ～ +10,,,\n"
			+ "加護,スキル ,,+1 ～ +7,+1 ～ +7,+3 ～ +7,,スキル ,,,-10 ～ +9,-7 ～ +10,\n"
			+ "英雄の盾,スキル ,,,,+1 ～ +5,,スキル ,,,-3 ～ +3,-1 ～ +3,\n"
			+ "回復量,スキル ,,+1 ～ +6,+1 ～ +6,+3 ～ +7,,スキル ,,,-3 ～ +4,-3 ～ +5,\n"
			+ "回復速度,スキル ,,+1 ～ +7,,,,スキル ,,-4 ～ +4,-10 ～ +12,,\n"
			+ "效果持続,スキル ,+1 ～ +8,,,,,スキル ,,-10 ～ +10,,,\n"
			+ "广域,スキル ,+1 ～ +8,+1 ～ +8,,,,スキル ,,-10 ～ +10,-10 ～ +12,-5 ～ +12,\n"
			+ "腹減り,スキル ,+1 ～ +8,+1 ～ +8,,,,スキル ,,-10 ～ +10,-10 ～ +10,,\n"
			+ "食いしん坊,スキル ,+1 ～ +10,,,,,スキル ,,-10 ～ +13,,,\n"
			+ "食事,スキル ,,+1 ～ +4,+1 ～ +5,+2 ～ +6,,スキル ,,,-3 ～ +3,-3 ～ +5,\n"
			+ "节食,スキル ,,+1 ～ +3,+1 ～ +5,+3 ～ +7,,スキル ,,-5 ～ +5,-5 ～ +5,-5 ～ +7,\n"
			+ "肉食,スキル ,,+1 ～ +3,+1 ～ +5,,,スキル ,,-5 ～ +5,-5 ～ +5,,\n"
			+ "茸食,スキル ,,,,,,スキル ,,,-3 ～ +3,-3 ～ +5,\n"
			+ "野草知識,スキル ,+1 ～ +8,+1 ～ +8,,,,スキル ,,-10 ～ +10,,,\n"
			+ "调合成功率,スキル ,+1 ～ +10,,,,,スキル ,,-10 ～ +13,,,\n"
			+ "调合数,スキル ,+1 ～ +8,,,,,スキル ,,-10 ～ +10,,,\n"
			+ "高速設置,スキル ,+1 ～ +8,+1 ～ +8,,,,スキル ,,-10 ～ +10,,,\n"
			+ "采取,スキル ,+1 ～ +10,,,,,スキル ,,-10 ～ +13,,,\n"
			+ "ハチミツ,スキル ,+1 ～ +8,+1 ～ +8,,,,スキル ,,-10 ～ +10,,,\n"
			+ "护石王,スキル ,,+1 ～ +3,+1 ～ +7,+3 ～ +7,,スキル ,,-5 ～ +5,-8 ～ +10,-7 ～ +10,\n"
			+ "气まぐれ,スキル ,+1 ～ +10,,,,,スキル ,,-10 ～ +13,,,\n"
			+ "运气,スキル ,,,,,,スキル ,,,-3 ～ +3,-5 ～ +7,\n"
			+ "剥ぎ取り,スキル ,,,,,,スキル ,,,-3 ～ +3,-3 ～ +5,\n"
			+ "捕獲,スキル ,,,,,,スキル ,,,-3 ～ +3,-5 ～ +7,\n"
			+ "ベルナ,スキル ,,,,,,スキル ,,,,,\n"
			+ "ココット,スキル ,,,,,,スキル ,,,,,\n"
			+ "ポッケ,スキル ,,,,,,スキル ,,,,,\n"
			+ "ユクモ,スキル ,,,,,,スキル ,,,,,\n"
			+ "龙识船,スキル ,,,,,,スキル ,,,,,\n"
			+ "飞行酒場,スキル ,,,,,,スキル ,,,,,\n"
			+ "红兜,スキル ,,,,,,スキル ,,,-3 ～ +3,,\n"
			+ "大雪主,スキル ,,,,,,スキル ,,,-3 ～ +3,,\n"
			+ "矛砕,スキル ,,,,,,スキル ,,,-3 ～ +3,,\n"
			+ "岩穿,スキル ,,,,,,スキル ,,,-3 ～ +3,,\n"
			+ "紫毒姫,スキル ,,,,,,スキル ,,,-3 ～ +3,,\n"
			+ "宝缠,スキル ,,,,,,スキル ,,,-3 ～ +3,,\n"
			+ "白疾風,スキル ,,,,,,スキル ,,,-3 ～ +3,,\n"
			+ "单眼,スキル ,,,,,,スキル ,,,-3 ～ +3,,\n"
			+ "黑炎王,スキル ,,,,,,スキル ,,,-3 ～ +3,,\n"
			+ "金雷公,スキル ,,,,,,スキル ,,,-3 ～ +3,,\n"
			+ "荒钩爪,スキル ,,,,,,スキル ,,,-3 ～ +3,,\n"
			+ "烬灭刃,スキル ,,,,,,スキル ,,,-3 ～ +3,,\n"
			+ "胧隐,スキル ,,,,,,スキル ,,,-3 ～ +3,,\n"
			+ "铠裂,スキル ,,,,,,スキル ,,,-3 ～ +3,,\n"
			+ "天眼,スキル ,,,,,,スキル ,,,-3 ～ +3,,\n"
			+ "青电主,スキル ,,,,,,スキル ,,,-3 ～ +3,,\n"
			+ "银岭,スキル ,,,,,,スキル ,,,-3 ～ +3,,\n"
			+ "鏖魔,スキル ,,,,,,スキル ,,,-3 ～ +3,,\n"
			+ "真・紅兜,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "真・大雪主,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "真・矛砕,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "真・岩穿,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "真・紫毒姫,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "真・宝纏,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "真・白疾風,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "真・隻眼,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "真・黒炎王,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "真・金雷公,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "真・荒鉤爪,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "真・燼滅刃,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "真・朧隠,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "真・鎧裂,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "真・天眼,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "真・青電主,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "真・銀嶺,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "真・鏖魔,スキル ,,,,,,スキル ,,,,-3 ～ +3,\n"
			+ "北辰納豆流,スキル ,,,,,,スキル ,,,,,\n"
			+ "斩术,スキル ,,,,,,スキル ,,,,,\n"
			+ "食欲,スキル ,,,,,,スキル ,,,,,\n"
			+ "职工,スキル ,,,,,,スキル ,,,,,\n"
			+ "刚腕,スキル ,,,,,,スキル ,,,,,\n"
			+ "祈愿,スキル ,,,,,,スキル ,,,,,\n"
			+ "里稼業,スキル ,,,,,,スキル ,,,,,\n"
			+ "刀匠,スキル ,,,,,,スキル ,,,,,\n"
			+ "射手,スキル ,,,,,,スキル ,,,,,\n"
			+ "状态耐性,スキル ,,,,,,スキル ,,,,,\n"
			+ "怒,スキル ,,,,,,スキル ,,,,,\n"
			+ "回避術,スキル ,,,,,,スキル ,,,,,\n"
			+ "居合,スキル ,,,,,,スキル ,,,,,\n"
			+ "顽强,スキル ,,,,,,スキル ,,,,,\n"
			+ "刚击,スキル ,,,,,,スキル ,,,,,\n"
			+ "盾持,スキル ,,,,,,スキル ,,,,,\n"
			+ "洁癖,スキル ,,,,,,スキル ,,,,,\n"
			+ "增幅,スキル ,,,,,,スキル ,,,,,\n"
			+ "护石収集,スキル ,,,,,,スキル ,,,,,\n"
			+ "强欲,スキル ,,,,,,スキル ,,,,,\n"
			+ "对钢龍,スキル ,,,,,,スキル ,,,,,\n"
			+ "对霞龍,スキル ,,,,,,スキル ,,,,,\n"
			+ "对炎龍,スキル ,,,,,,スキル ,,,,,\n"
			+ "胴系統倍加,スキル ,,,,,,スキル ,,,,,\n"
			+ "秘术,スキル ,,,,,,スキル ,,,,,\n"
			+ "护石強化,スキル ,,,,,,スキル ,,,,,\n";
			
	public talisman(){
		parseAllSkillLimit();
	}
	
	public void parseAllSkillLimit(){
		String[] lines = kiranico_skill_limits.split("\n"); //"毒,スキル ,+1 ～ +5,+1 ～ +5,,,,スキル ,,-10 ～ +7,,,\n" etc
		for (int i=0; i<206; i++){
			String line = lines[i].replace("+", "");
			String[] infoTokens = line.split(",スキル ,");
			String skillName = infoTokens[0];
			String firstSkillRange = infoTokens[1];
			String secondSkillRange = infoTokens[2];
			String[] skill1RangeToken = firstSkillRange.split(",", -1);
			String[] skill2RangeToken = secondSkillRange.split(",", -1);
			range rg1 = noRange, rg2 = noRange, rg3 = noRange, rg4 = noRange, rg5 = noRange, rg6 = noRange, rg7 = noRange, rg8 = noRange;
			if (skill1RangeToken[0].length()!=0){
				String[] rangeToken = skill1RangeToken[0].split(" ～ ");
				rg1 = new range(Integer.parseInt(rangeToken[0]), Integer.parseInt(rangeToken[1]));
			}
			if (skill1RangeToken[1].length()!=0){
				String[] rangeToken = skill1RangeToken[1].split(" ～ ");
				rg2 = new range(Integer.parseInt(rangeToken[0]), Integer.parseInt(rangeToken[1]));
			}
			if (skill1RangeToken[2].length()!=0){
				String[] rangeToken = skill1RangeToken[2].split(" ～ ");
				rg3 = new range(Integer.parseInt(rangeToken[0]), Integer.parseInt(rangeToken[1]));
			}
			if (skill1RangeToken[3].length()!=0){
				String[] rangeToken = skill1RangeToken[3].split(" ～ ");
				rg4 = new range(Integer.parseInt(rangeToken[0]), Integer.parseInt(rangeToken[1]));
			}
			if (skill2RangeToken[0].length()!=0){
				String[] rangeToken = skill2RangeToken[0].split(" ～ ");
				rg5 = new range(Integer.parseInt(rangeToken[0]), Integer.parseInt(rangeToken[1]));
			}
			if (skill2RangeToken[1].length()!=0){
				String[] rangeToken = skill2RangeToken[1].split(" ～ ");
				rg6 = new range(Integer.parseInt(rangeToken[0]), Integer.parseInt(rangeToken[1]));
			}
			if (skill2RangeToken[2].length()!=0){
				String[] rangeToken = skill2RangeToken[2].split(" ～ ");
				rg7 = new range(Integer.parseInt(rangeToken[0]), Integer.parseInt(rangeToken[1]));
			}
			if (skill2RangeToken[3].length()!=0){
				String[] rangeToken = skill2RangeToken[3].split(" ～ ");
				rg8 = new range(Integer.parseInt(rangeToken[0]), Integer.parseInt(rangeToken[1]));
			}
			singleSkillInfo s1 = new singleSkillInfo(rg1, rg2, rg3, rg4);
			s1.skillIndex = i;
			s1.skillName = skillName;
			skill1LimitTable[i] = s1;
			singleSkillInfo s2 = new singleSkillInfo(rg5, rg6, rg7, rg8);
			s2.skillIndex = i;
			s2.skillName = skillName;
			skill2LimitTable[i] = s2;
		}
		
	}
	
	public class singleSkillInfo{
		int skillIndex;
		String skillName;
		range[] rangeTable = new range[4]; //range[rarity]
		public singleSkillInfo(range rg1, range rg2, range rg3, range rg4){
			rangeTable[0] = rg1;
			rangeTable[1] = rg2;
			rangeTable[2] = rg3;
			rangeTable[3] = rg4;
		}
		public range getRange(int rarity){
			if (rarity>4 || rarity==0)
				return noRange;
			return rangeTable[rarity-1];
		}
		public int getIndex(){
			return skillIndex;
		}
		@Override
		public String toString(){
			if (selectedTalismanRarityType == 0)
				return skillName;
			else
				return skillName + rangeTable[selectedTalismanRarityType-1];
		}
	}

	
	public class range {
		int min;
		int max;
		public range(int a, int b){
			this.min = a;
			this.max = b;
		}
		@Override
		public String toString(){
			if (min == 0 && max == 0){
				return "";
			}
			else return " (" + min + " ～ "  + max + ")";
		}
	}
	

	public enum tType {
		R0("---"), R1("兵士护石"), R2("斗士护石"), R3("骑士护石"), R4("城赛护石"), R5("女王护石"), R6("王之护石"), R7("龙之护石"), R8("英雄护石"), R9("传说护石"), R10("天之护石");
		private final String typeName;
		private tType(String s) {
			typeName = s;
		}
		public static tType getIndex(String s) {  
	        for (tType c : tType.values()) {  
	            if (c.toString() == s) {  
	                return c;  
	            }  
	        }  
	        return R0;  
	    }
	    @Override
	    public String toString() {
	        return typeName;
	    }
	    public static int getCode(String s){
	    	tType t = getIndex(s);
	    	switch (t){
	    	case R1: return 1;
	    	case R2: return 2;
	    	case R3: return 3;
	    	case R4: return 4;
	    	case R5: return 5;
	    	case R6: return 6;
	    	case R7: return 7;
	    	case R8: return 8;
	    	case R9: return 9;
	    	case R10: return 10;
	    	default: return 0;
	    	}
	    }
	    public int getCode(tType t){
	    	switch (t){
	    	case R1: return 1;
	    	case R2: return 2;
	    	case R3: return 3;
	    	case R4: return 4;
	    	case R5: return 5;
	    	case R6: return 6;
	    	case R7: return 7;
	    	case R8: return 8;
	    	case R9: return 9;
	    	case R10: return 10;
	    	default: return 0;
	    	}
	    }
	}

	
	public class talismanSkill {
		public String skill;
		public int number;
		range[] skill1_limit = new range[4]; 
		
		public talismanSkill(String skill, int number){
			this.skill = skill;
			this.number = number;
		}
		
		public String getSkill(){
			return skill;
		}
		
		public int getNum(){
			return number;
		}
		
		@Override
		public String toString(){
			return skill;
		}
		
	}
	
	
	public static void addtalisman(int typeCode, int sk1Code, int sk2Code, int sk1Num, int sk2Num, int slot){
		if (Main.emptySpaceInEquipBoxOffset >= 72000){
			JOptionPane.showMessageDialog(null, "添加失败，您的装备箱可能已满");
			return;
		}
		int emptySpaceOffset = findEmptySpace();
		Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset] = 6;
		Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 2] = (byte) typeCode;
		Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 12] = (byte) sk1Code;
		Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 13] = (byte) sk2Code;
		Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 14] = (byte) sk1Num;
		Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 15] = (byte) sk2Num;
		Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 16] = (byte) slot;
		if (typeCode == 1) Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 18] = (byte)97;
		else if (typeCode == 2  || typeCode == 3 || typeCode == 4)	Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 18] = (byte)98;
		else if (typeCode == 5 || typeCode == 6  || typeCode == 7) Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 18] = (byte)99;
		else if (typeCode == 8 || typeCode == 9  || typeCode == 10) Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 18] = (byte)100;
		Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 19] = (byte)01;
		JOptionPane.showMessageDialog(null, "护石添加成功");
	} 
	
	public static int findEmptySpace(){
		for (int i = 0; i<36; i++){
			if (Main.buffer[Main.useroffset + Main.equipmentBoxOffset + Main.emptySpaceInEquipBoxOffset + i] != (byte)0){
				Main.emptySpaceInEquipBoxOffset += 36;
				return findEmptySpace();
			}
		}
		return Main.emptySpaceInEquipBoxOffset;
	}
	

}
