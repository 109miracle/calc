package main;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * 
 * 精确四则运算方法
 * @author zhangjc
 *
 */
public class Arith {
    /**
     * 提供精确加法计算的add方法
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public double addArith(double value1,double value2){
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.add(b2).doubleValue();
    }
    
    /**
     * 提供精确减法运算的sub方法
     * @param value1 被减数
     * @param value2 减数
     * @return 两个参数的差
     */
    public double subArith(double value1,double value2){
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.subtract(b2).doubleValue();
    }
    
    /**
     * 提供精确乘法运算的mul方法
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public double mulArith(double value1,double value2){
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.multiply(b2).doubleValue();
    }
    
    /**
     * 提供精确的除法运算方法div
     * @param value1 被除数
     * @param value2 除数
     * @param scale 精确范围
     * @return 两个参数的商
     * @throws IllegalAccessException
     */
    public double divArith(double value1,double value2,int scale) throws IllegalAccessException{
        //如果精确范围小于0，抛出异常信息
        if(scale<0){         
            throw new IllegalAccessException("精确度不能小于0");
        }
        MathContext mc = new MathContext(scale, RoundingMode.HALF_DOWN);
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.divide(b2,mc).doubleValue();    
    }
	public double openArith(double value) throws IllegalAccessException{
		if(value<0){
			throw new IllegalAccessException("根号内不能小于0");
		}
        return java.lang.Math.sqrt(value);    
	}
	public double sinArith(double value){
		return Math.sin(Math.PI*value/180);
	}
	public double cosArith(double value){
		return Math.cos(Math.PI*value/180);
	}
	public double tanArith(double value){
		return Math.tan(Math.PI*value/180);
	}
	public double cotArith(double value){
		return (1/Math.tan(Math.PI*value/180));
	}
}
	
