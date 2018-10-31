public class MainClient{
	public static void main(String[] args){
		//declaring a 2D array
		String[][] users = new String[6][5];
		users[0] = {"a","b","c","d","e"};
		users[1] = {"a1","b","c","d","e"};
		users[2] = {"a2","b","c","d","e"};
		users[3] = {"a3","b","c","d","e"};
		users[4] = {"a4","b","c","d","e"};
		users[5] = {"a5","b","c","d","e"};
		//scan
		Scanner scanner = new Scanner(System.in);
		
		//声明一个用户名变量
		String clientLoginName = null;
		
		while(true){
		//TODO loging in
			//是否需要登录，true需要，false不需要
			boolean flag = true;
			int loginCount = 0;
			while(flag){
				if loginCount == 3{
					System.out.println("错误3次，退出系统")；
					System.exit(0);
				}
				loginCount++;
				
				System.out.println("请输入用户名：")；
				String uname = Scanner.next();
			
				System.out.println("请输入密码")；
				string pwd = Scanner.next();
			
				//用户名为空判断
				if(uname.trim().length() == 0{
					System.out.println("用户名不能为空！")；
					continue;
				}
			
				//循环遍历，找到用户名
				int n = -1;
				for( i=0, len=users.length; i<len; i++){
					if(uname.trim().equals(users[i][3])){
						n = i;
						break;
					}
				}
			
				if(n<0){
					System.out.println("用户名不存在")；
					continue;
				}
			
				//用户名存在，已确定 n 值，开始匹配密码
				if(pwd.trim().length() == 0){
					System.out.println("密码不能为空")；
					continue;
				}
				
				if(pwd.trim().equals(users[n][4]){
					System.out.println("登录成功")；
					clientLoginName = uname;
					flage = false；
				}else{
					System.out.println("密码错误")；
					continue；
				}		
			}
		
		//TODO Menu
			int code =0;
			
			while(true){
				if(loginName == null){
					break;
				}
				
				System.out.println();
				System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * *");
				System.out.println("*		客户信息管理系统		*");
				System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * *");
				System.out.println("1. 显 示 所 有 用 户 信 息");
				System.out.println("2. 添 加 用 户 信 息");
				System.out.println("3. 修 改 用 户 信 息");
				System.out.println("4. 查 询 用 户 信 息");
				System.out.println("5. 删 除 用 户 信 息");
				System.out.println("6. 退  出");
				System.out.println("7. 注 销 登 录");
				System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * *");

				System.out.println("请输入代码：");	
				code = Scanner.next();
				
				switch (code){
					case1:
						System.out.println("显 示 所 有 用 户 信 息");
						for(String[] user : users){
							System.out.println(Array.toString(user));
						}
						break;
					case2:
						System.out.println("添 加 用 户 信 息");
						System.out.println("请输入ID:");
						//标记，true输入异常，false没有异常
						boolean uflag = false;
						String uid2 = scanner.next();
						for(String[] user : users){
							if(uid2.trim().equals(user[0])){
								System.out.println("ID已存在，返回主菜单")；
								uflag = true；
								break;
							}
						}
						if (uflag) {
							break;
						}
						
						System.out.println("请输入姓名:");
						String uname = scanner.next();

						System.out.println("请输入年龄:");
						String age = scanner.next();

						System.out.println("请输入用户名:");
						String loginName = scanner.next();
						for(String[] user : users){
							if(loginName.trim().equals(user[3])){
								System.out.println("用户名已经存在，返回主菜单！");
								uflag = true;
								break;
							}
						}
						if (uflag) {
							break;
						}
						
						System.out.println("请输入密码:");
						String pwd = scanner.next();
						if(pwd == null || pwd.trim().length() == 0){
							flag = true;
						}
						if(uflag){
							break;
						}
												
						System.out.println("请输入工资:");
						String salary = scanner.next();
					    
					    String[][] newusers = Array.copyOf(users,users.length+1);
						String[] user11 = new String[6];
						user11[0] = uid2;
						user11[1] = uname;
						user11[2] = age;
						user11[3] = loginname;
						user11[4] = pwd;
						user11[5] = salary;
						newusers[newusers.length-1] = user11;
						
						users = newusers;
						
						break;
					
					case3:
						System.out.println("修 改 用 户 信 息");
						System.out.println("当前系统中存在的ID：");
						for(String[] user : users){
							System.out.println(user[0]);
						}
						System.out.println("请输入要查询的用户的ID：");
						String uid0 = Scanner.next();
						String[] user1 = null;
						for(String[] user : users){
							if(uid0.trim().equals(user[0]){
								user1 = user;
								break;
							}
						}
						
						if (user1 == null){
							System.out.println("对不起，您输入的用户ID有误！返回主菜单！");
						}else{
							System.out.println("请输入姓名：");
							user1[1] = scanner.next();
							System.out.println("请输入年龄：");
							user1[2] = scanner.next();
							System.out.println("请输入密码：");
							user1[4] = scanner.next();
							System.out.println("请输入工资：");
							user1[5] = scanner.next();
							System.out.println("修改保存成功。返回主菜单！");
						}
						break;
						
					case4:
						System.out.println("查 询 用 户 信 息");
						System.out.println("当前系统中存在的ID：");
						for (String[] user : users) {
							System.out.println(user[0]);
						}
						System.out.println("请输入要查询的用户的ID：");
						String uid = scanner.next();
						String temp = null;// 用于记录找到的那个用户的字符串
						for (String[] user : users) {
							if (uid.trim().equals(user[0])) {
							// 找到了这个id的数组用户
							// 数组中的数据赋值给 temp
								temp = Arrays.toString(user);
							// 跳出for循环
								break;
							}
						}
						
						if(temp == null){
							System.out.println("对不起，您输入的用户ID有误！返回主菜单！");
						}else {
							System.out.println(temp);
						}
						break;
						
						
					case5:
						System.out.println("删 除 用 户 信 息");
						System.out.println("当前系统中存在的ID：");
						for (String[] user : users) {
							System.out.println(user[0]);
						}
						System.out.println("请输入要查询的用户的ID：");
						String uid1 = scanner.next();
						int index = -1;
						for(int i = 0, len=users.length; i<len; i++){
							if (uid1.trim().equals(users[i][0])){
								index = i;
								break;
							}
						}
						if(index<0){
							System.out.println("对不起，您输入的用户ID有误！返回主菜单！");
							break;
						}
						
						String[][] userstmp = new String[]users.length-1[6];
						for(int i = 0, len = userstmp.length; i<len; i++){
							if(i >= index){
								userstmp[i] = users[i+1];
							}else{
								userstmp[i] = users[i]
							}
						}
						users = userstmp;
						System.out.println("删除成功，返回主菜单！");
						break;
						
					case6:
						System.out.println("谢谢使用，再见！");
						return;
						
					case7:
						System.out.println("注销登录！");
						clientloginname = null;
						break;
					default:
						System.out.println("对不起，您输入的代码有误，请重新输入！");
						break;				
				}
			}			
	}
}
