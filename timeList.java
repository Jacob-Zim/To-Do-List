
public class timeList {
	// to do list (active = true inactive = false)
	private boolean listArray;
	// time entry
	private String time;
	
	public timeList(String time, boolean listArray) {
		this.time = time;
		this.listArray = listArray;
	}
	
	public String getTime() {
		return time;
	}
	
	public boolean getListArray() {
		return listArray;
	}
}
