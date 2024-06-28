javac -d ./bin src/main/java/com/algoriant/sms/model/Student.java
javac -d ./bin -cp ./conf/:./lib/* src/main/java/com/algoriant/sms/service/DBService.java
javac -d ./bin -cp ./lib/*:./conf/:./bin src/main/java/com/algoriant/sms/dao/StudentDAO.java
javac -d ./bin -cp ./lib/*:./conf/:./bin src/main/java/com/algoriant/sms/dao/impl/StudentDAOImpl.java
javac -d ./bin -cp ./bin:./conf/ src/main/java/com/algoriant/sms/UIClass.java
java -cp ./bin:./lib/*:./conf/ com.algoriant.sms.UIClass
