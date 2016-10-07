package cal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * 
 * ��ȷ�������㷽��
 */
public class Arith {
    /**
     * �ṩ��ȷ�ӷ������add����
     * @param value1 ������
     * @param value2 ����
     * @return ���������ĺ�
     */
    public double addArith(double value1,double value2){
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.add(b2).doubleValue();
    }
    
    /**
     * �ṩ��ȷ���������sub����
     * @param value1 ������
     * @param value2 ����
     * @return ���������Ĳ�
     */
    public double subArith(double value1,double value2){
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.subtract(b2).doubleValue();
    }
    
    /**
     * �ṩ��ȷ�˷������mul����
     * @param value1 ������
     * @param value2 ����
     * @return ���������Ļ�
     */
    public double mulArith(double value1,double value2){
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.multiply(b2).doubleValue();
    }
    
    /**
     * �ṩ��ȷ�ĳ������㷽��div
     * @param value1 ������
     * @param value2 ����
     * @param scale ��ȷ��Χ
     * @return ������������
     * @throws IllegalAccessException
     */
    public double divArith(double value1,double value2,int scale) throws IllegalAccessException{
        //�����ȷ��ΧС��0���׳��쳣��Ϣ
        if(scale<0){         
            throw new IllegalAccessException("��ȷ�Ȳ���С��0");
        }
        MathContext mc = new MathContext(scale, RoundingMode.HALF_DOWN);
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.divide(b2,mc).doubleValue();    
    }
	public double openArith(double value) throws IllegalAccessException{
		if(value<0){
			throw new IllegalAccessException("�����ڲ���С��0");
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
	
