package com.spiderman.security;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * @author Administrator
 * @version 1.0
 **/
//@RunWith(SpringRunner.class)
public class TestBCrypt {


    public static void main(String[] args) {
        //对密码进行加密
        String hashpw = BCrypt.hashpw("secret", BCrypt.gensalt());
        System.out.println(hashpw);

        //校验密码
        boolean checkpw = BCrypt.checkpw("secret", "$2a$10$NlBC84MVb7F95EXYTXwLneXgCca6/GipyWR5NHm8K0203bSQMLpvm");
        boolean checkpw2 = BCrypt.checkpw("123", "$2a$10$HuClcUqr/FSLmzSsp9SHqe7D51Keu1sAL7tUAAcb..FyILiLdFKYy");
        System.out.println(checkpw);
        System.out.println(checkpw2);
    }
}
