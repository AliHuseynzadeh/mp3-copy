import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	private static ArrayList<Integer> content = new ArrayList<Integer>();

	public static void file_reader() {
		FileInputStream fin=null;
		try {
			 fin = new FileInputStream("HoldUs.mp3"); //kopyalanacaq mp3 adi və həmin mp3 fayllarin içində olmalidi
			int number;
			while ((number = fin.read()) != -1) {
				content.add(number);
				//System.out.println(number);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("File not reading");
		}
		finally {
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void file_writer(String name) {
		FileOutputStream fon=null;
		try {
			fon = new FileOutputStream(name);
			for (int iteration : content) {
				fon.write(iteration);
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("io exception");
		}
		finally {
			try {
				fon.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
	long starter=System.currentTimeMillis();
		file_reader();
		file_writer("new.mp3");//yeni mp3 adi
		long finish=System.currentTimeMillis();
		System.out.print("Second : "+(finish-starter)/1000);
	}

}


