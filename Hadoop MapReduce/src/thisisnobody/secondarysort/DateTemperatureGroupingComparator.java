package thisisnobody.secondarysort;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * The DateTemperatureGroupingComparator class enable us to compare two
 * DateTemperaturePair objects. This class is needed for sorting purposes.
 * 
 * 
 * comment by zlp
 * 将DateTemperaturePair作为map输出的key，温度值作为map输出的value
 * mapreduce框架会自动按照key进行分区，洗牌，排序
 * 
 * 
 * 如何判断map输出的value是否需要划分到相同的DateTemperaturePair上
 * 设置job.setGroupingComparatorClass(DateTemperatureGroupingComparator.class);
 * 
 * @author Mahmoud Parsian
 *
 */
public class DateTemperatureGroupingComparator extends WritableComparator {

	public DateTemperatureGroupingComparator() {
		super(DateTemperaturePair.class, true);
	}

	/**
	 * Compare two objects
	 * 
	 * @param wc1
	 *            a WritableComparable object, which represents a
	 *            DateTemperaturePair
	 * @param wc2
	 *            a WritableComparable object, which represents a
	 *            DateTemperaturePair
	 * @return 0, 1, or -1 (depending on the comparison of two DateTemperaturePair
	 *         objects).
	 */
	@Override
	public int compare(WritableComparable wc1, WritableComparable wc2) {
		DateTemperaturePair pair = (DateTemperaturePair) wc1;
		DateTemperaturePair pair2 = (DateTemperaturePair) wc2;
		return pair.getYearMonth().compareTo(pair2.getYearMonth());
	}
}
