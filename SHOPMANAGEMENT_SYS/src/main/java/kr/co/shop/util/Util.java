package kr.co.shop.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import kr.co.shop.vo.OrderHisVO;

public class Util {

	public static String fileRepository = "";
	
	//서버 아이피
	public static String getServerIp(){
		
		String ip = "";
		
		try {
			InetAddress local = InetAddress.getLocalHost();
			
			ip = local.getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return ip;
	}
	
	//폴더 생성
	public static void addFolder(File file, String path){
		if( file.exists() ) {
			if( file.isDirectory() ) {
				if( file.canRead() && file.canWrite() ) {
					fileRepository = file.getAbsolutePath();
				} else {
					throw new IllegalArgumentException( path + " 읽기 또는 쓰기 권한 없음." );
				}
			} else {
				throw new IllegalArgumentException( "fileRepositoryPath 값은 디렉토리 경로를 지정해야함. ["+path+"]" );
			}
		} else {
			System.out.println( "지정된 디렉토리가 없어 생성함. ["+ path +"]" );
			if( file.mkdir() ) {
				fileRepository = file.getAbsolutePath();
			} else {
				throw new IllegalArgumentException( "설정된 디렉토리 생성실패 [" +path+"]" );
			}
		}
	}
	
	//주문입력시 박스 숫자만큼 송장번호 입력
	public static ArrayList<String> songjangArr(Sheet sheet, int index, int box_cnt){

        int rowindex = index;
        int columnindex = 0;
        ArrayList<String> list2 = new ArrayList<>();
        
        XSSFRow row = (XSSFRow) sheet.getRow(rowindex);
        if(row != null){
            //셀의 수
            int cells = row.getPhysicalNumberOfCells();
            for(columnindex = 13; columnindex < (cells + box_cnt); columnindex++) {
            	
                //셀값을 읽는다
                XSSFCell cell = row.getCell(columnindex);
                String value = "";
                
                if(cell == null){
                	list2.add(value);
                }else{
                	switch (cell.getCellType()){
                        case XSSFCell.CELL_TYPE_FORMULA:
                            value = cell.getCellFormula();
                            break;
                        case XSSFCell.CELL_TYPE_NUMERIC:
                        	cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                        	value = cell.getStringCellValue();
                            break;
                        case XSSFCell.CELL_TYPE_STRING:
                            value = cell.getStringCellValue();
                            break;
                        case XSSFCell.CELL_TYPE_BLANK:
                            value = cell.getBooleanCellValue() + "";
                            break;
                        case XSSFCell.CELL_TYPE_ERROR:
                            value = cell.getErrorCellValue() + "";
                            break;
                    }
                }
                
                if(value != null && value.equals("false")) {
                	value = "";
                }
                
                list2.add(value);
            }
        }
		return list2;
	}
	
	//주문 엑셀 쓰기
	public static FileOutputStream orderAttachExcel(List<HashMap<String, Object>> returnList1) throws IOException {
		
		String filePath = "D:\\Shop\\엑셀 양식\\주문.xlsx";
		
		FileInputStream inputStream = new FileInputStream(filePath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);
 
		for(int i = 0; i < returnList1.size(); i++) {
			row = sheet.createRow(i + 1);
		    row.createCell(0).setCellValue(returnList1.get(i).get("product_no").toString());
		    row.createCell(1).setCellValue(returnList1.get(i).get("option_no").toString());
		    row.createCell(2).setCellValue(returnList1.get(i).get("receive_nm").toString());
		    row.createCell(3).setCellValue(returnList1.get(i).get("receive_tel").toString());
		    row.createCell(4).setCellValue(returnList1.get(i).get("receive_tel_etc").toString());
		    row.createCell(5).setCellValue(returnList1.get(i).get("receive_address").toString());
		    row.createCell(6).setCellValue(returnList1.get(i).get("send_nm").toString());
		    row.createCell(7).setCellValue(returnList1.get(i).get("send_tel").toString());
		    row.createCell(8).setCellValue(returnList1.get(i).get("send_tel_etc").toString());
		    row.createCell(9).setCellValue(returnList1.get(i).get("send_address").toString());
		    row.createCell(10).setCellValue(returnList1.get(i).get("product_title").toString());
		    row.createCell(11).setCellValue(returnList1.get(i).get("box_cnt").toString());
		    row.createCell(12).setCellValue(returnList1.get(i).get("message").toString());
		}

		FileOutputStream outFile = new FileOutputStream("D:\\Shop\\임시저장\\주문.xlsx");
		workbook.write(outFile);
		outFile.close();
		inputStream.close();
		
		return outFile;
	}
}
