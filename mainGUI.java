public class mainGUI {
	
	public static timeList[] createTimeList(String[] timeArray, boolean[] listArray) {
		timeList[] mainTimeList = new timeList[listArray.length];
		for (int i = 0; i < listArray.length; i++) {
			if (listArray[i]) {
				timeList mainTimeListEntry = new timeList(timeArray[i], listArray[i]);
				mainTimeList[i] = mainTimeListEntry;
			} else if (!listArray[i]) {
				mainTimeList[i] = new timeList("", listArray[i]);
			}
		} return mainTimeList;
	}

	public static void main(String[] args) {
		boolean[] listArray = {true, true, false, false};
		String[] timeArray = {"11:30", "16:45"};
		timeList[] a = createTimeList(timeArray, listArray);
		System.out.println(a[1].getListArray());
		System.out.println(a[3].getListArray());
		System.out.println(a[1].getTime());
		System.out.println(a[0].getTime());
	}
}
