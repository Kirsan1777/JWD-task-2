package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ApplianceDAOImpl implements ApplianceDAO{ // класс реализации

	@Override
	public Appliance find(Criteria criteria) throws IOException {
		List<String> listAppliance = readFile();
		for(String i : listAppliance){
			if(i.contains(criteria.getGroupSearchName())){
				System.out.println("Your product is " + i);
			}
		}
		return null;
	}

	public List<String> readFile() throws IOException {
		List<String> listWithAppliance = new ArrayList<>();
		FileReader fileReader = new FileReader("C:\\Users\\Nikita\\Desktop\\temp.txt");
		//BufferedReader bufferedReader = new BufferedReader(fileReader);

		try(BufferedReader bufferedReader = new BufferedReader(fileReader))
		{
			//чтение построчно
			String s;
			while((s=bufferedReader.readLine())!=null){
				listWithAppliance.add(s);
			}

		}
		catch(IOException ex){
			System.out.println(ex.getMessage());

		}

		return listWithAppliance;
	}


		// you may add your own code here
}
	
	// you may add your own code here
