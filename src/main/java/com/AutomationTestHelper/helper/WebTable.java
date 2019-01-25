package com.AutomationTestHelper.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTable {
	
	private WebElement _webTable;
	
	public WebTable(WebElement webTable)
	{
		_webTable = webTable;
		
	}
	
	public WebElement getWebTable()
	{
		return _webTable;
	}
	
	public int getRowCount()
	{
		return _webTable.findElements(By.xpath("tbody/tr")).size();		
	}
	
	public int getColumnCount()
	{
		WebElement firstDataRow = _webTable.findElement(By.xpath("tbody/tr"));	
		return firstDataRow.findElements(By.tagName("td")).size();
	}
	
	public WebElement getRowElement(int rowNumber)
	{
		return _webTable.findElement(By.xpath("tbody/tr["+rowNumber+"]"));
	}
	
	public WebElement getCellElement(int rowNumber, int colNumber)
	{
		return _webTable.findElement(By.xpath("tbody/tr["+rowNumber+"]/td["+colNumber+"]"));
	}
	
	public String getCellText(int rowNumber, int colNumber)
	{
		return getCellElement(rowNumber, colNumber).getText();
	}
	
	public String[] getTextDisplayedInRow(int rowNumber)
	{
		int colCount = getColumnCount();
		String[] tableRowData = new String[colCount];
		
		for(int i=1; i<colCount; i++)
		{
			tableRowData[i-1] = getCellElement(rowNumber,i).getText();
		}
		
		return tableRowData;
		
	}
	
	public String[] getTextDisplayedInColumn(int colNumber)
	{
		int rowCount = getRowCount();

		String[] tableColData = new String[rowCount];
		
		for(int i=1; i<=rowCount; i++)
		{
			tableColData[i-1] = getCellElement(i, colNumber).getText();
		}
		
		return tableColData;	
	}
	
	public String[][] getTextDisplayedInAllRows()
	{
		int rowCount = getRowCount();
		int colCount = getColumnCount();

		String[][] allTableRowsData = new String[rowCount][colCount];
		
		for(int i=1; i<=rowCount; i++)
		{
			for(int j=1; j<=colCount; j++)
			{
				allTableRowsData[i-1][j-1] = getCellElement(i,j).getText();
			}
		}
		
		return allTableRowsData;
	}
	
	public WebElement getCellElement(String cellText)
	{
		String cellXPath = "tbody/tr/td[contains(.,'" + cellText +"')]";
		return _webTable.findElement(By.xpath(cellXPath));
	}
	
	public WebElement getRowElement(String rowText)
	{
		String rowXPath = "tbody/tr[contains(.,'" + rowText +"')]";
		return _webTable.findElement(By.xpath(rowXPath));
	}
	
	
	public void clickCellElement(String cellText)
	{
		String cellXPath = "tbody/tr/td[contains(.,'" + cellText +"')]";
		WebElement element = _webTable.findElement(By.xpath(cellXPath));
		
		element.click();
	}
		
}
