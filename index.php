<?php
   //package required
    require_once 'vendor/autoload.php';
    require_once 'common/Application.php';
    require 'rb.php';
    
    Application::registerAutoloader();
   
    $app = new Application();
    
    //Signup user check
    $app->post('/hello/signup/', function(){
        global $app;
        $response = new stdClass();
        
        //Check for an existing user
        $checkUser = R::getRow("SELECT username FROM users WHERE username = ?", [$app->getRequest()->username]);
        
        //if no esxiting user create a new one
        if($checkUser == null){
         $data = R::exec("INSERT INTO users (username,password,age,gender,email) VALUES (?,?,?,?,?)", [$app->getRequest()->username, 
                                 $app->getRequest()->password, $app->getRequest()->age, $app->getRequest()->gender, $app->getRequest()->email]);
         $response->status = true;
        }
        
        else
        $response->status = false;
        
        echo json_encode($response);
    });
    
    
    //Login user check
    $app->post('/hello/', function () {
        global $app;
        
        $loginValue = new stdClass();
        
        $checkBoth = R::getRow("SELECT username,password FROM users WHERE username = ? AND password = ?", 
                                                  [$app->getRequest()->username, $app->getRequest()->password]);
                                                  
        $checkUser = R::getRow("SELECT username FROM users WHERE username = ?", [$app->getRequest()->username]);
        
        if($checkBoth != null)
        $loginValue->loginValue = 1;
        else if($checkBoth == null && $checkUser != null)
        $loginValue->loginValue = 2;
        else
        $loginValue->loginValue = 3;
         
        echo json_encode($loginValue);
        
     });
	 
	 //DB connection info (mySQL)
    $host = "brsatalay.com";
    $dbname = "barisatalay_staj";
    $dbuser = "sanstaj";
    $dbpassword = "pY1_tg88";
    
    //Establish connection
     R::setup('mysql:host='.$host.';dbname='.$dbname, $dbuser, $dbpassword);
     
     R::freeze(true);
    
    
     //Close connection
     //R::close();
     
     $app->run();
     
   
?>
	 