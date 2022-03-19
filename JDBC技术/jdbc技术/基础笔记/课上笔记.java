/*//加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获得连接对象  Connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodtogo", "root", "root");
//        System.out.println(connection);
        //获得Statement对象，执行sql语句
        Statement statement = connection.createStatement();
        //执行SQL   executeUpdate:添加，修改，删除  executeQuery : 查询
        //String sql = "insert into user values(3,'zhangsan','aaa','china','34234234')";
        //String sql = "update user set username='bbbb'";
        //String sql = "delete from user where userid = 3";
        //受影响的行数
        //int i = statement.executeUpdate(sql);
        //System.out.println(i);

        *//**
 * 查询
 * ----ORM   对象关系映射
 *//*
        String sql = "select * from user";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            User user = new User();
            user.setUserid(resultSet.getInt(1));
            user.setUsername(resultSet.getString(2));
            user.setPhone(resultSet.getString(5));
            user.setUserpwd(resultSet.getString(3));
            user.setAddress(resultSet.getString(4));
            System.out.println(user)；*/

//jdbc连接数据库的步骤？
//        1.加载驱动
//        2.获得连接
//        3.获得Statement
//        4.执行sql
//        5.处理结果