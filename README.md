# Jersey RESTful Tutorial

* Thêm Archetype Canalog để tạo nhanh một project Maven với jersey

> http://repo1.maven.org/maven2/archetype-catalog.xml

![Imgur](https://i.imgur.com/pohZw6V.png)
--
* Đoạn code kết nối mysql dùng xampp

>     String url = "jdbc:mysql://localhost:3306/test";
>     		String username = "root";
>     		
>     		try {
>     			Class.forName("com.mysql.jdbc.Driver");
>     			conn = DriverManager.getConnection(url,username,"");
>     		} catch (SQLException e) {
>     			// TODO Auto-generated catch block
>     			e.printStackTrace();
>     		} catch (ClassNotFoundException e) {
>     			// TODO Auto-generated catch block
>     			e.printStackTrace();
>     		}
