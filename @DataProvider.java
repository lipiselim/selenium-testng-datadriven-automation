FileInputStream tem = new FileInputStream(src);
HSSFWorkbook wb = new HSSFWorkbook(tem);
HSSFSheet s = wb.getSheet("Sheet1");

int rows = s.getLastRowNum() + 1;
int columns = s.getRow(0).getLastCellNum();
String inputData[][] = new String[rows][columns];

for (int i = 1; i < rows; i++) {
    HSSFRow r = s.getRow(i);
    for (int j = 0; j < columns; j++) {
        HSSFCell c = r.getCell(j);
        String value = c.toString();
        inputData[i][j] = value;
        System.out.println("The value is " + value);
    }
}

wb.close();
return inputData;
