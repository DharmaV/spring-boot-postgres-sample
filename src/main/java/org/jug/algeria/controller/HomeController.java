package org.jug.algeria.controller;

import org.jug.algeria.domain.AppList;

import org.jug.algeria.domain.SavedSet;

import org.jug.algeria.domain.SavedSetList;
import org.jug.algeria.repository.UserRepository;
import org.jug.algeria.repository.SavedSetRepository;
import org.jug.algeria.repository.SavedSetListRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.Date;
import java.util.Collection;


@RestController
//@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeController {

  final UserRepository userRepository;
  final SavedSetRepository savedSetRepository;
  final SavedSetListRepository savedSetListRepository;

  @Inject
  public HomeController(SavedSetRepository savedSetRepository,UserRepository userRepository,SavedSetListRepository savedSetListRepository) {
    this.savedSetRepository = savedSetRepository;
    this.userRepository= userRepository;
    this.savedSetListRepository=savedSetListRepository;
  }

  @GetMapping
  public ModelAndView home() {
    return new ModelAndView("index");
  }

  @GetMapping(value = "/hello")
  public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok().body("Hello there !");
  }

    @PostMapping(value = "/list/{listname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppList> create(@PathVariable String listname) {
    AppList appUser = new AppList();
    appUser.setListName(listname);
    appUser.setSavedSetName("Sairam");
    AppList saved = userRepository.save(appUser);
    return ResponseEntity.ok().body(saved);
  }
  /*
  public ResponseEntity<AppList> create(@PathVariable String listname) {
	  AppList appUser = new AppList();
    appUser.setListName(listname);
    appUser.setSavedSetName("Sairam");
    AppList saved = userRepository.save(appUser);
    return ResponseEntity.ok().body(saved);
  }

   @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<AppList>> findAll() {
    final List<AppList> resultList = new ArrayList<>();
    final Iterable<AppList> all = userRepository.findAll();
    all.forEach(resultList::add);
    return ResponseEntity.ok().body(resultList);
  }
*/
  @PostMapping(value = "/savelist/{listname}/{keyproductqueryitem}/{keys}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<SavedSet> saveList(@PathVariable String listname,@PathVariable long keyproductqueryitem,@PathVariable String keys) {

    SavedSet savedSet = new SavedSet();
    savedSet.setSavedSet(listname);
    savedSet.setKeyOnlineUser(1073874574);
    //savedSet.setFormOrder(10);
    //savedSet.setUpdOperation(2);
    savedSet.setUpdDate(new Date());
    //savedSet.setKeyProductQueryItem(243327);
    savedSet.setKeyProductQueryItem(keyproductqueryitem);
    savedSet.setUserLastSaved(new Date());
    savedSet.setLastCriteriaSaved(new Date());
    //savedSet.setKeyWebClientWorkflow(10);
    savedSet.setSavedSetAssumption("{'keyScenario':'Somebody s Fifth Mine Cost Scenario','test':00005}");
    SavedSet saved = savedSetRepository.save(savedSet);
List<String> list2 = Arrays.asList(keys.split(","));

  for (String  app : list2) {
  System.out.println("/lists ----------?"+app);
   SavedSetList ssList=new SavedSetList();
    ssList.setKeySavedSet(saved.getKeySavedSet());
    ssList.setSavedSetValue(app);
    ssList.setKeyProductQueryItem(125078);
    //ssList.setUpdOperation(2);
    ssList.setUpdDate(new Date());
    SavedSetList savedList = savedSetListRepository.save(ssList);
}

System.out.println("/lists ----------?"+keys);
   
    return ResponseEntity.ok().body(saved);
  }

 @PutMapping(value = "/updatelist/{keysavedset}/{listname}/{keyproductqueryitem}/{keys}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<SavedSet> saveList(@PathVariable long keysavedset,@PathVariable String listname,@PathVariable long keyproductqueryitem,@PathVariable String keys) {

    SavedSet savedSet = new SavedSet();
    savedSet.setSavedSet(listname);
    savedSet.setKeyOnlineUser(1073874574);
    savedSet.setKeySavedSet(keysavedset);
    //savedSet.setFormOrder(10);
    //savedSet.setUpdOperation(2);
    savedSet.setUpdDate(new Date());
    //savedSet.setKeyProductQueryItem(243327);
    savedSet.setKeyProductQueryItem(keyproductqueryitem);
    savedSet.setUserLastSaved(new Date());
    savedSet.setLastCriteriaSaved(new Date());
    //savedSet.setKeyWebClientWorkflow(10);
    savedSet.setSavedSetAssumption("{'keyScenario':'Somebody s Fifth Mine Cost Scenario','test':00005}");
    SavedSet saved = savedSetRepository.save(savedSet);

 final Iterable<SavedSetList> all2 = savedSetListRepository.findByKeySavedSet(keysavedset);
      for (SavedSetList app : all2) {
          System.out.println("child list"+ app.getSavedSetValue());
          savedSetListRepository.delete(app.getKeySavedSetList());
      }
    
    List<String> list2 = Arrays.asList(keys.split(","));

  for (String  app : list2) {
  System.out.println("/lists ----------?"+app);
   SavedSetList ssList=new SavedSetList();
    ssList.setKeySavedSet(saved.getKeySavedSet());
    ssList.setSavedSetValue(app);
    ssList.setKeyProductQueryItem(125078);
    //ssList.setUpdOperation(2);
    ssList.setUpdDate(new Date());
    SavedSetList savedList = savedSetListRepository.save(ssList);
}

    System.out.println("/lists ----------?"+keys);
   
    return ResponseEntity.ok().body(saved);
  }


   @PostMapping(value = "/savelistobject", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<SavedSet> saveListObject(@RequestParam(value = "Name", required = false) String Name,
                                         
                                         @RequestParam(value = "Keys", required = false) String Keys) {
    
    SavedSet savedSet = new SavedSet();
    savedSet.setSavedSet(Name);
    savedSet.setKeyOnlineUser(1073874574);
    //savedSet.setFormOrder(10);
    //savedSet.setUpdOperation(2);
    savedSet.setUpdDate(new Date());
    savedSet.setKeyProductQueryItem(6666);
    savedSet.setUserLastSaved(new Date());
    savedSet.setLastCriteriaSaved(new Date());
    //savedSet.setKeyWebClientWorkflow(10);
    savedSet.setSavedSetAssumption("{'keyScenario':'Somebody s Fifth Mine Cost Scenario','test':00005}");
    SavedSet saved = savedSetRepository.save(savedSet);
  System.out.println("/lists ----------?"+Keys);

    SavedSetList ssList=new SavedSetList();
    ssList.setKeySavedSet(saved.getKeySavedSet());
    ssList.setSavedSetValue("99969");
    ssList.setKeyProductQueryItem(125078);
    //ssList.setUpdOperation(2);
    ssList.setUpdDate(new Date());
    SavedSetList savedList = savedSetListRepository.save(ssList);
    return ResponseEntity.ok().body(saved);
  }

   @PutMapping(value = "/updatelist", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<SavedSet> updateListObject(@PathVariable String Name,
                                           @RequestBody SavedSet ss) {
    
    SavedSet savedSet = new SavedSet();
    savedSet.setSavedSet(Name);
    savedSet.setKeyOnlineUser(1073874574);
    //savedSet.setFormOrder(10);
    //savedSet.setUpdOperation(2);
    savedSet.setUpdDate(new Date());
    //savedSet.setKeyProductQueryItem(KeyProductQueryItem);
    savedSet.setUserLastSaved(new Date());
    savedSet.setLastCriteriaSaved(new Date());
    //savedSet.setKeyWebClientWorkflow(10);
    savedSet.setSavedSetAssumption("{'keyScenario':'Somebody s Fifth Mine Cost Scenario','test':00005}");
    SavedSet saved = savedSetRepository.save(savedSet);


    SavedSetList ssList=new SavedSetList();
    ssList.setKeySavedSet(saved.getKeySavedSet());
    ssList.setSavedSetValue("99969");
    ssList.setKeyProductQueryItem(125078);
    //ssList.setUpdOperation(2);
    ssList.setUpdDate(new Date());
    SavedSetList savedList = savedSetListRepository.save(ssList);
    return ResponseEntity.ok().body(saved);
  }

 
  
  @RequestMapping("/getlists")
  //public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
  public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
  	System.out.println("/lists ----------?");
  	
  	String contents = "<tr><td><b>List Name::</b></td><td><b>Owner</b></td><td><b>Last Updated</b></td></tr>";
  	
  	final List<SavedSet> resultList = new ArrayList<>();
    final Iterable<SavedSet> all = savedSetRepository.findAll();
    all.forEach(resultList::add);
    
	    for (SavedSet app : resultList) {
			contents = contents + "<tr><td><a href=# target='_blank' onclick=window.open('/listDetails.html','mywin','width=500,height=200'); >" + app.getSavedSet() +"</a></td>"
			+"<td> Owner </td><td>01-13-2017</td></tr>";
		}

      return "<table border='1' width='100%'>"+contents+"</table><table>"+
      "<tr><td><a href=# target='_blank' onclick=window.open('/createpage','mywin','width=500,height=200'); >Create List</a></td></tr>"+
      "<tr><td><a href='/deleteall'>Delete All</a></td></tr></table>";
  }

  @RequestMapping("/lists")
  //public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
  public @ResponseBody List<SavedSet> getLists(@RequestParam(value="name", defaultValue="World") String name) {
    System.out.println("/lists ----------?");
    
      
    final List<SavedSet> resultList = new ArrayList<>();
    final Iterable<SavedSet> all = savedSetRepository.findAll();
    all.forEach(resultList::add);

     final Iterable<SavedSetList> all2 = savedSetListRepository.findByKeySavedSet(1);
     //String[] testarray = new String[((Collection<SavedSetList>)all2).size()];
     List<String> keyList = new ArrayList<String>();
      for (SavedSetList app : all2) {
          System.out.println("child list"+ app.getSavedSetValue());
          keyList.add(app.getSavedSetValue().toString());
    
      }

    return resultList;
  }
 
 @RequestMapping("/list/{keysavedset}")
  //public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
  public @ResponseBody SavedSet getListById(@PathVariable long keysavedset) {
    System.out.println("/lists ----------?");
    
      
    
    SavedSet all = savedSetRepository.findOne(keysavedset);
     final Iterable<SavedSetList> all2 = savedSetListRepository.findByKeySavedSet(keysavedset);
     //String[] testarray = new String[((Collection<SavedSetList>)all2).size()];
     List<String> keyList = new ArrayList<String>();
      for (SavedSetList app : all2) {
          System.out.println("child list"+ app.getSavedSetValue());
          keyList.add(app.getSavedSetValue().toString());
    
      }
      String[] array = keyList.toArray( new String[keyList.size()] );
      all.setKeys(array);
    
 
    return all;
  }
}
