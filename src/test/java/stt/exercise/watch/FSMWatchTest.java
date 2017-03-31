package stt.exercise.watch;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import stt.exercise.watch.FSMWatch;
import stt.exercise.watch.WatchEvents;
import stt.exercise.watch.WatchStates;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FSMWatchTest {
	@Test
	@Parameters({"pressSet, setHrs, Showing Set Hrs",
		"pressMode,Altimeter, Showing Altimeter"})
	public void testTimeState(WatchEvents eventToDo, WatchStates expectedState, String expectedDisplay){
		FSMWatch fw = new FSMWatch(WatchStates.Time, "Showing Time", 0, 0);
		fw.processEvent(eventToDo);
		assertEquals(expectedState, fw.getCurrentWatchState());
		assertEquals(expectedDisplay, fw.getWatchDisplay());
	}
	
	@Test
	@Parameters({"pressSet, Altimeter, Showing Altimeter",
		"pressMode,Time,Showing Time"})
	public void testAltimeterState(WatchEvents eventToDo, WatchStates expectedState, String expectedDisplay){
		FSMWatch fw = new FSMWatch(WatchStates.Altimeter, "Showing Altimeter", 0,0);
		fw.processEvent(eventToDo);
		assertEquals(expectedState, fw.getCurrentWatchState());
		assertEquals(expectedDisplay, fw.getWatchDisplay());
	}
	
	@Test
	@Parameters({"pressSet, setHrs, Showing Set Hrs, 5, 10, 6, 10",
		"pressSet, setHrs, Showing Set Hrs, 23, 10, 0, 10",
		"pressMode, Time, Showing Time, 0, 5, 0, 5"})
	public void testSetHrsState(WatchEvents eventToDo, WatchStates expectedState, String expectedDisplay,
			int currentHour, int currentMinute, int expectedHour, int expectedMinute){
		FSMWatch fw = new FSMWatch (WatchStates.setHrs, "Showing Set Hrs", currentHour, currentMinute);
		fw.processEvent(eventToDo);
		assertEquals(expectedState, fw.getCurrentWatchState());
		assertEquals(expectedDisplay, fw.getWatchDisplay());
		assertEquals(expectedHour, fw.getCurrentHrs());
		assertEquals(expectedMinute, fw.getCurrentMins());
	}
	
	@Test
	@Parameters({"pressSet, setMins, Showing Set Mins, 5, 10, 5, 11",
		"pressSet, setMins, Showing Set Mins, 5, 59, 5, 00",
		"pressMode, Time, Showing Time, 0, 5, 0, 5"})
	public void testSetMinsState(WatchEvents eventToDo, WatchStates expectedState, String expectedDisplay,
			int currentHour, int currentMinute, int expectedHour, int expectedMinute){
		FSMWatch fw = new FSMWatch(WatchStates.setMins, "Showing Set Mins", currentHour, currentMinute);
		fw.processEvent(eventToDo);
		assertEquals(expectedState, fw.getCurrentWatchState());
		assertEquals(expectedDisplay, fw.getWatchDisplay());
		assertEquals(expectedHour, fw.getCurrentHrs());
		assertEquals(expectedMinute, fw.getCurrentMins());
	}
	
	private Object[] paramForSingle(){
		return new Object[]{
			new Object[]{"Time, Showing Time, pressSet, setHrs, Showing Set Hrs, 0, 0, 0, 0"},
			new Object[]{"Time, Showing Time, pressMode,Altimeter, Showing Altimeter, 0, 0, 0, 0"},
			new Object[]{"Altimeter, Showing Altimeter, pressSet, Altimeter, Showing Altimeter, 0, 0, 0, 0"},
			new Object[]{"Altimeter, Showing Altimeter, pressMode,Time,Showing Time, 0, 0, 0, 0"},
			new Object[]{"setHrs, Showing Set Hrs, pressSet, setHrs, Showing Set Hrs, 5, 10, 6, 10"},
			new Object[]{"setHrs, Showing Set Hrs, pressSet, setHrs, Showing Set Hrs, 23, 10, 0, 10"},
			new Object[]{"setHrs, Showing Set Hrs, pressMode, Time, Showing Time, 0, 5, 0, 5"},
			new Object[]{"setMins, Showing Set Mins, pressSet, setMins, Showing Set Mins, 5, 10, 5, 11"},
			new Object[]{"setMins, Showing Set Mins, pressSet, setMins, Showing Set Mins, 5, 59, 5, 00"},
			new Object[]{"setMins, Showing Set Mins, pressMode, Time, Showing Time, 0, 5, 0, 5"}
		};
	}
	
	@Test
	@Parameters({
		"Time, Showing Time, pressSet, setHrs, Showing Set Hrs, 0, 0, 0, 0",
		"Time, Showing Time, pressMode,Altimeter, Showing Altimeter, 0, 0, 0, 0",
		"Altimeter, Showing Altimeter, pressSet, Altimeter, Showing Altimeter, 0, 0, 0, 0",
		"Altimeter, Showing Altimeter, pressMode,Time,Showing Time, 0, 0, 0, 0",
		"setHrs, Showing Set Hrs, pressSet, setHrs, Showing Set Hrs, 5, 10, 6, 10",
		"setHrs, Showing Set Hrs, pressSet, setHrs, Showing Set Hrs, 23, 10, 0, 10",
		"setHrs, Showing Set Hrs, pressMode, Time, Showing Time, 0, 5, 0, 5",
		"setMins, Showing Set Mins, pressSet, setMins, Showing Set Mins, 5, 10, 5, 11",
		"setMins, Showing Set Mins, pressSet, setMins, Showing Set Mins, 5, 59, 5, 00",
		"setMins, Showing Set Mins, pressMode, Time, Showing Time, 0, 5, 0, 5"
	})
	public void testSingleParam(WatchStates initialState, String initialDisplay, 
			WatchEvents eventToDo, WatchStates expectedState, String expectedDisplay,
			int currentHour, int currentMinute, int expectedHour, int expectedMinute){
		FSMWatch fw = new FSMWatch(initialState, initialDisplay, currentHour, currentMinute);
		fw.processEvent(eventToDo);
		assertEquals(expectedState, fw.getCurrentWatchState());
		assertEquals(expectedDisplay, fw.getWatchDisplay());
		assertEquals(expectedHour, fw.getCurrentHrs());
		assertEquals(expectedMinute, fw.getCurrentMins());
	}
}
