package com.stock.StockMarket;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping(path="/demo")

public class MainController {
@Autowired 
  private AdminRepository adminRepository;
  @Autowired
  private UserRepository userRepository; 
  @Autowired
  private CompanyRepo companyrepo;
  @Autowired
  private Iporepo iporepo;
  @Autowired
  private Stockexchangerepo stockexchangerepo;
  @Autowired
  private StockpriceRepo stockpricerepo;
  @RequestMapping(path="/add",method={RequestMethod.POST}) 
  public @ResponseBody String addNewUser (@RequestBody Admin admin) {
    adminRepository.save(admin);
    return "Saved";
  }
  @PostMapping(path="/addcompany") 
  public @ResponseBody String addnewcompany (@RequestBody Company company) {
	    companyrepo.save(company);
	    return "Saved";
	  }
  @RequestMapping(path="/addipo") 
  public @ResponseBody String addnewcompany (@RequestParam int id,@RequestParam String comp_name,@RequestParam String stockexchange,@RequestParam long price,
	       @RequestParam long totalshare,@RequestParam Date date_time,@RequestParam String remark) {
	    Ipo n = new Ipo();
	    n.setId(id);
	    n.setComp_name(comp_name);
	    n.setStockexchange(stockexchange);
	    n.setTotalshare(totalshare);
	    n.setDate_time(date_time);
	    n.setRemark(remark);
	    iporepo.save(n);
	    return "Saved";
	  }
  @RequestMapping(path="/adduser",method={RequestMethod.POST}) 
  public @ResponseBody String addNewUser (@RequestBody User user) {
    
    userRepository.save(user);
    return "Save";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Admin> getAlladmin() {
    return adminRepository.findAll();
  }
  @GetMapping(path="/company")
  public @ResponseBody Iterable<Company> getAllCompany() {
    return companyrepo.findAll();
  }
  @GetMapping(path="/ipodetails")
  public @ResponseBody Iterable<Ipo> getAllIpo() {
    return iporepo.findAll();
  }
  @GetMapping(path="/stockexchange")
  public @ResponseBody Iterable<Stockexchange> getAllstock() {
    return stockexchangerepo.findAll();
  }
  @GetMapping(path="/stockprice")
  public @ResponseBody Iterable<Stockprice> getAllstockprice() {
    return stockpricerepo.findAll();
  }
  
  @GetMapping(path="/all1")
  public @ResponseBody Iterable<User> getAllUsers() {
	
    return userRepository.findAll();
  }
  @PutMapping(path="/updatecom")          
  public @ResponseBody String update(@RequestBody Company updatecompany) {
    
    companyrepo.save(updatecompany);
    return "Updated";
  }
  @GetMapping(path="/byid/{id}")
  public @ResponseBody Admin getById(@PathVariable Integer id) {
    return adminRepository.findById(id).get();
  }
  @GetMapping(path="/bycompany1/{Stockcode}")
  public @ResponseBody Company getById1(@PathVariable Integer Stockcode) {
    return companyrepo.findById(Stockcode).get();
  }
 @RequestMapping(path="/delete" ,method={RequestMethod.GET, RequestMethod.POST}) 
 public List<Admin> deleteone()
 {
	 adminRepository.deleteAll();
	 return (List<Admin>) adminRepository.findAll();
	 
 }
 @RequestMapping(path="/deletecom/{id}",method={RequestMethod.GET, RequestMethod.POST})          
 public @ResponseBody String Delete(@PathVariable Integer Stockcode) {
   
   companyrepo.deleteById(Stockcode);
   return "Updated";  
 }
 @RequestMapping(path="/check",method={RequestMethod.GET, RequestMethod.POST})
 public @ResponseBody String userLogin(@RequestBody User user) {
	  User user1 = userRepository.getByEmailAndPassword(user.getEmail(),user.getPassword());
	  if(user1!=null) {
		  return "sucess";
	  }
	  else {
		  return "failed";
	  }
	  
 }

 @PostMapping("/file")
 public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
    String message="";
    try {
       try {
       	//FileInputStream fis = new FileInputStream(file);
       	XSSFWorkbook wb = new XSSFWorkbook(file.getInputStream()); 
       	XSSFSheet sheet = wb.getSheetAt(0);
       	Iterator<Row> itr = sheet.iterator();
       	Row row1 = itr.next();
       	while (itr.hasNext() )                 
       	{ 
       	Stockprice s1=new Stockprice();
       	Row row = itr.next();
       	Iterator<Cell> cellIterator = row.cellIterator();  
       	//while (cellIterator.hasNext())   
       	//{ 
       	    Cell cell = cellIterator.next();  
       		s1.setCompanycode(cell.getStringCellValue());
       		Cell cell1 = cellIterator.next();
       		s1.setStockExchange(cell1.getStringCellValue());
       		Cell cell2 = cellIterator.next();
       		s1.setStockPrice(cell2.getNumericCellValue());
       		Cell cell3 = cellIterator.next();
       		s1.setDateofstock(cell3.getDateCellValue());
      		    Cell cell4 = cellIterator.next();
       		s1.setStocktime(cell4.getStringCellValue());
       		
       	stockpricerepo.save(s1);
       	}
       }
       	catch(Exception e)  
       	{  
       	e.printStackTrace();
       } 
       return ResponseEntity.status(HttpStatus.OK).body(message);
    } catch (Exception e) {
       message = "Failed to upload!";
       return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
    }
 }
}