import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
	public static void main(String [] args){
		//common data
		boolean b=false;
		long p=0, a=0, y1=0, y2=0;
		//users
		User user1 = new User() ,user2 = new User();
		long k1=0, k2=0, temp=1;
		try(BufferedWriter wr = new BufferedWriter(new FileWriter("log.txt"))){
			wr.write("");
			wr.write(">> Алгоритм Диффи-Хеллмана <<\r\n");
			wr.write((char)7+" Введите простое число для расчёта P >>");
			System.out.println(" Введите простое число для расчёта P >>");
			Scanner in = new Scanner(System.in);
			while(!b) {
				if(in.hasNextInt()){
					p=in.nextInt();
					for(int i=2;i<p;i++) {
						if(p%i==0) {
							System.out.println("Введенное число не является простым.Попробуйте еще раз >>");
							wr.append("\r\n" + (char)7+" Введенное число не является простым.Попробуйте еще раз >>");
							b=false;
							break;
						}
						else b=true;
					}
				}
			}
			wr.append(p+"\r\n");
			wr.append("");
			wr.append((char)7+" Введите А, такое что 1<A<"+(p-1)+" >>");
			System.out.println("Введите А, такое что 1<A<"+(p-1)+" >>");
			if(in.hasNextInt()){
				a=in.nextInt();
				while((int)(Math.pow(a, (p/2)-1)%p)==1) {
					wr.append((char)7+" Попробуйте другое А >>");
					if(in.hasNextInt()){
						a=in.nextInt();
						if((a<1)||a>(p-1)){
							throw new IllegalArgumentException();
						}
					}
				}
			}
			wr.append(a+"\r\n");
			wr.append((char)7+" USER1 генерирует секретное чило "+user1.generate(p)+"\r\n");
			y1=user1.count(p, a);
			wr.append((char)7+ " USER1  вычисляет y1 "+y1+"\r\n");
			wr.append((char)7+" USER2  генерирует секретное число "+user2.generate(p)+"\r\n");
			y2=user2.count(p, a);
			wr.append((char)7+" USER2 вычисляет y2 "+y2+"\r\n");
			wr.append((char)7+" USERS обмениваются y..."+"\r\n");
			k1=user1.key(y2, p);
			k2=user2.key(y1, p);
			wr.append((char)7+ " USER1 считает ключ "+k1+"\r\n");
			wr.append((char)7+ " USER2 считает ключ "+k2+"\r\n");
			if(k1==k2) wr.append((char)7+" Ключи равны");
			else wr.append((char)7+" Ключи не равны =(");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
