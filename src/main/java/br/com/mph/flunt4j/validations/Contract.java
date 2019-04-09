package br.com.mph.flunt4j.validations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;

import br.com.mph.flunt4j.notifications.Notifiable;

public class Contract extends Notifiable {
	
	private static final String NULL_MESSAGE = "Cannot compare using those operands because at least one of them is null";

	public Contract requires(){
		return this;
	}
	
	private boolean verifyNullOperands(String property, Object val, Object comparer){		
		if (val == null || comparer == null){
			addNotification(property,NULL_MESSAGE);
			return true;
		}
		return false;
	}
	
	private boolean verifyNullOperands(String property, Object val, Object from, Object to) {		
		if (val == null || from == null || to == null){
			addNotification(property,NULL_MESSAGE);
			return true;
		}
		return false;
	}
	
	public Contract join(Notifiable[] items){
		for (Notifiable item: items){
			if (item.invalid()){
				addNotifications(item.getNotifications());
			}
		}
		return this;
	}
	
	public Contract isNotNull(Object val, String property, String message){
		if (val == null){
			addNotification(property, message);
		}
		return this;
	}
	
	public Contract isTrue(boolean val, String property, String message){
		if (!val){
			addNotification(property, message);
		}
		return this;
	}
	
	public Contract isFalse(boolean val, String property, String message){
		if (val){
			addNotification(property, message);
		}
		return this;
	}
	
	public Contract isGreaterThan(LocalDate val, LocalDate comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (!val.isAfter(comparer)){
				addNotification(property, message);
			}	
		} 		
		return this;
	}
	
	public Contract isGreaterThan(LocalDateTime val, LocalDateTime comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (!val.isAfter(comparer)){
				addNotification(property, message);
			}	
		}		
		return this;
	}
	
	public Contract isGreaterOrEqualsThan(LocalDate val, LocalDate comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val.isBefore(comparer)){
				addNotification(property, message);
			}	
		}		
		return this;
	}
	
	public Contract isGreaterOrEqualsThan(LocalDateTime val, LocalDateTime comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val.isBefore(comparer)){
				addNotification(property, message);
			}	
		}		
		return this;
	}
	
	public Contract isLowerThan(LocalDate val, LocalDate comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (!val.isBefore(comparer)){
				addNotification(property, message);
			}	
		}		
		return this;
	}
	
	public Contract isLowerThan(LocalDateTime val, LocalDateTime comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (!val.isBefore(comparer)){
				addNotification(property, message);
			}	
		}		
		return this;
	}
	
	public Contract isLowerOrEqualsThan(LocalDate val, LocalDate comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val.isAfter(comparer)){
				addNotification(property, message);
			}	
		}		
		return this;
	}
	
	public Contract isLowerOrEqualsThan(LocalDateTime val, LocalDateTime comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (!val.isAfter(comparer)){
				addNotification(property, message);
			}	
		}		
		return this;
	}
	
	public Contract isBetween(LocalDate val, LocalDate from, LocalDate to, String property, String message){
		if (!verifyNullOperands(property, val, from, to)){
			if (val.isBefore(from) || val.isAfter(to)){
				addNotification(property, message);
			}	
		}		
		return this;
	}		

	public Contract isBetween(LocalDateTime val, LocalDateTime from, LocalDateTime to, String property, String message){
		if (!verifyNullOperands(property, val, from, to)){
			if (val.isBefore(from) || val.isAfter(to)){
				addNotification(property, message);
			}	
		}		
		return this;
	}
	
	public Contract isGreaterThan(BigDecimal val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val.compareTo(comparer) <= 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isGreaterThan(double val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(comparer) <= 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isGreaterThan(float val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(comparer) <= 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isGreaterThan(int val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(comparer) <= 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isGreaterOrEqualsThan(BigDecimal val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val.compareTo(comparer) < 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isGreaterOrEqualsThan(double val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(comparer) < 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isGreaterOrEqualsThan(float val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(comparer) < 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isGreaterOrEqualsThan(int val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(comparer) < 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isLowerThan(BigDecimal val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val.compareTo(comparer) >= 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isLowerThan(double val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(comparer) >= 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isLowerThan(float val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(comparer) >= 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isLowerThan(int val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(comparer) >= 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isLowerOrEqualsThan(BigDecimal val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val.compareTo(comparer) > 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isLowerOrEqualsThan(double val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(comparer) > 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isLowerOrEqualsThan(float val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(comparer) > 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isLowerOrEqualsThan(int val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(comparer) > 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract areEquals(BigDecimal val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val.compareTo(comparer) != 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract areEquals(double val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(comparer) != 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract areEquals(float val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(comparer) != 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract areEquals(int val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(comparer) != 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract areNotEquals(BigDecimal val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val.compareTo(comparer) == 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract areNotEquals(double val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(comparer) == 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract areNotEquals(float val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(comparer) == 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract areNotEquals(int val, BigDecimal comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(comparer) == 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isBetween(BigDecimal val, BigDecimal from, BigDecimal to, String property, String message){
		if (!verifyNullOperands(property, val, from, to)){
			if (val.compareTo(from) < 0 || val.compareTo(to) > 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isGreaterThan(BigDecimal val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val.doubleValue() <= comparer){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isGreaterThan(double val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val <= comparer){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isGreaterThan(float val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val <= comparer){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isGreaterThan(int val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val <= comparer){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isGreaterOrEqualsThan(BigDecimal val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val.doubleValue() < comparer){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isGreaterOrEqualsThan(double val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val < comparer){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isGreaterOrEqualsThan(float val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val < comparer){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isGreaterOrEqualsThan(int val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val < comparer){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isLowerThan(BigDecimal val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val.doubleValue() >= comparer){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isLowerThan(double val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val >= comparer){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isLowerThan(float val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val >= comparer){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isLowerThan(int val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val >= comparer){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isLowerOrEqualsThan(BigDecimal val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val.doubleValue() > comparer){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isLowerOrEqualsThan(double val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val > comparer){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isLowerOrEqualsThan(float val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val > comparer){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isLowerOrEqualsThan(int val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val > comparer){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract areEquals(BigDecimal val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val.compareTo(new BigDecimal(comparer)) != 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract areEquals(double val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(new BigDecimal(comparer)) != 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract areEquals(float val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(new BigDecimal(comparer)) != 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract areEquals(int val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val != comparer){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract areNotEquals(BigDecimal val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val.compareTo(new BigDecimal(comparer)) == 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract areNotEquals(double val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(new BigDecimal(comparer)) == 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract areNotEquals(float val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (new BigDecimal(val).compareTo(new BigDecimal(comparer)) == 0){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract areNotEquals(int val, int comparer, String property, String message){
		if (!verifyNullOperands(property, val, comparer)){
			if (val == comparer){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isBetween(int val, int from, int to, String property, String message){
		if (!verifyNullOperands(property, val, from, to)){
			if (val < from || val > to){
				addNotification(property, message);
			}
		}
		return this;
	}
	
	public Contract isNotNullOrEmpty(String val, String property, String message){
		if (val == null || StringUtils.isEmpty(val)){
			addNotification(property, message);
		}
		return this;
	}
	
	public Contract isNullOrEmpty(String val, String property, String message){
		if (val != null && !StringUtils.isEmpty(val)){
			addNotification(property, message);
		}
		return this;
	}
	
	public Contract HasMinLen(String val, int min, String property, String message)
    {
        if (val == null || StringUtils.isEmpty(val) || val.length() < min)
            addNotification(property, message);

        return this;
    }

    public Contract HasMaxLen(String val, int max, String property, String message)
    {
        if (val == null || StringUtils.isEmpty(val) || val.length() > max) 
            addNotification(property, message);

        return this;
    }

    public Contract HasLen(String val, int len, String property, String message)
    {
        if ((val != null && !StringUtils.isEmpty(val)) || val.length() != len)
            addNotification(property, message);

        return this;
    }

    public Contract Contains(String val, String text, String property, String message)
    {
        // TODO: StringComparison.OrdinalIgnoreCase not suported yet
        if (!val.contains(text))
            addNotification(property, message);

        return this;
    }

    public Contract AreEquals(String val, String text, String property, String message)
    {
        // TODO: StringComparison.OrdinalIgnoreCase not suported yet
        if (!val.equals(text))
            addNotification(property, message);

        return this;
    }

    public Contract AreNotEquals(String val, String text, String property, String message)
    {
        // TODO: StringComparison.OrdinalIgnoreCase not suported yet
        if (val.equals(text))
            addNotification(property, message);

        return this;
    }

}
