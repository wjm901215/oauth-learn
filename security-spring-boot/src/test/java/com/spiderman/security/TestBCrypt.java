//package com.spiderman.security;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @author Administrator
// * @version 1.0
// **/
//@RunWith(SpringRunner.class)
//public class TestBCrypt {
//
//    @Test
//    public  void bCryptTest() {
//        //对密码进行加密
//        String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());
//        System.out.println(hashpw);
//
//        //校验密码
//        boolean checkpw = BCrypt.checkpw("123", "$2a$10$pApu4N5q.NFos50QBLuWjOCRgSe5v0fuXzHiIrMFRT4OfgshdatQa");
//        System.out.println(checkpw);
//    }
//}
