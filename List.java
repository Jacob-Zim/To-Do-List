import java.util.Arrays;

import javax.swing.JTextArea;
//TODO make the list not extend if you hit add and there is no text
//current the range is broken for the array ... the 50 values
public class List {

	private int count = 0;

	public int nullCount(String[] toDoList) {
		int nullcount = 0;
		for (int i = 0; i < toDoList.length; i++) {
			if (toDoList[i] == null) {
				nullcount++;
			}
		}
		return nullcount;
	}

	// adds and removes
	public String[] addToDo(String[] toDoList, String newToDo) {
		int tempCount = 0;
		int modifier = 0;
		String[] tempArray;
		// makes the array one longer if the current length plus one is greater
		// than 50
		if ((toDoList.length + 1) - nullCount(toDoList) > 50) {
			modifier = 1;
		}
		if ((toDoList.length + 1) - nullCount(toDoList) <= 50) {
			modifier = 0;
		}
		tempArray = new String[toDoList.length + modifier];
		for (int i = 0; i < toDoList.length; i++) {
			tempArray[i] = toDoList[i];
		}
		// determines the spot to put the new value
		// length has to be toDoList so it doesn't set a value that doesn't
		// exist to tempAray
		for (int i = 0; i < toDoList.length; i++) {
			if (toDoList[i] != null) {
				tempCount = tempCount + 1;
			}
		}
		tempArray[tempCount] = newToDo;
		count++;
		return tempArray;
	}

	// is not working because: needs to take in a string and find that string
	// and set it to null, then sort the array...
	// all done in the removeToDo Method right here:
	public String[] removeToDo(String[] toDoList, String removeToDo) {
		String[] tempArray;
		int modifier = 0;
		int tempNullCount = 0;
		
		if (toDoList.length - 1 > 50) {
			modifier = 1;
		}
		if (toDoList.length - 1 <= 50) {
			modifier = 0;
		}
		
		tempArray = new String[toDoList.length + modifier];
		
		int arrayLocation = Arrays.asList(toDoList).indexOf(removeToDo); 
		
		tempArray[arrayLocation] = null;
		for (int i = 0; i < toDoList.length; i++) {
			if (toDoList[i] == null)
				tempNullCount++;
		}
		for (int i = 0; i < toDoList.length; i++) {
			if (toDoList[i] == null) {
				toDoList[i] = toDoList[i+tempNullCount];
			}
			tempArray = toDoList;
		}
		count--;
		return tempArray;
	}

	public int getListLength(String[] toDoList) {
		if (toDoList.length <= 50) {
			return 50;
		}
		return toDoList.length;
	}

	public void SetText(JTextArea list, String[] toDoList) {
		JTextArea tempList = new JTextArea();
		tempList = list;
		list.setText(null);
		//TODO add a way to skip null values
		for (int i = 0; i < count; i++) {
			list.setText((tempList.getText() + toDoList[i] + "\n"));
		}
	}

	public int getCount() {
		return count;
	}
	// new method that clears the list every time

	// to make the remove method
	// same as add, for loop if any of them are equal, would delete it.
}
