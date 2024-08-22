package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController() {
		super();
	}
	
	private String os() {
		String os = System.getProperty("os.name");
		//System.out.println(os);
		return os;
	}

	/*public void ip () {
		String os = os();
		if (os.contains("Windows")) {
			try {
				readIP("ipconfig");
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}  
		} else if (os.contains("Linux")){
			try {
				readIP("ifconfig");
			} catch (Exception e) {
				try {
					Runtime.getRuntime().exec("ip addr");
				} catch (Exception e1) {
					System.err.println("Error: " + e1.getMessage());  
			    }
			}
		}
	}*/
	
	public void ip() {
		String[] linhaArray;
		String linhaSub;
		String adaptRede = "";
		String process;
		String os = os();
		
		if (os.contains("Windows")) {
			process = "ipconfig";
			try {
				
				Process proc = Runtime.getRuntime().exec(process);
				
				InputStream flow = proc.getInputStream();
				InputStreamReader reader = new InputStreamReader(flow);
				BufferedReader buffer = new BufferedReader(reader);
				String linha = buffer.readLine();
				
				while (linha != null) {
					if(linha.contains("Adaptador")) {
						adaptRede = linha;
					}
					if (linha.contains("IPv4")) {
						linhaArray = linha.split(" ");
						System.out.println(adaptRede + " IPv4 - " + linhaArray[linhaArray.length-1]);
					}
					linha = buffer.readLine();
				}
				
				buffer.close();
				reader.close();
				flow.close();
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} else if (os.contains("Linux")) {
			process = "ip addr";
			try {
				
				Process proc = Runtime.getRuntime().exec(process);
				
				InputStream flow = proc.getInputStream();
				InputStreamReader reader = new InputStreamReader(flow);
				BufferedReader buffer = new BufferedReader(reader);
				String linha = buffer.readLine();
				
				while (linha != null) {
					if(linha.contains("<")) {
						adaptRede = linha;
					}
					if (linha.contains("inet ")) {
						String[] linhArray = linha.split(" ");
						String[] adaptArray = adaptRede.split(" ");
						System.out.println(adaptArray[2] + " ip -" + linhArray[1]);
					}
				}
				
				buffer.close();
				reader.close();
				flow.close();
				
			} catch (Exception e1) {
				System.err.println(e1.getMessage());
			}
		}
	}

	public void ping () {
		String os = os();
		if (os.contains("Windows")) {
			try {
				Process proc = Runtime.getRuntime().exec("ping -4 -n 10 www.google.com.br");
				InputStream flow = proc.getInputStream();
				InputStreamReader reader = new InputStreamReader(flow);
				BufferedReader buffer = new BufferedReader(reader);
				String linha = buffer.readLine();
				
				while (linha != null) {
					if (linha.contains("dia")) {
						String[] linhArray1 = linha.split(",");
						String[] linhArray2 = linhArray1[2].split(" ");
						System.out.println(linhArray2[3]);
					}
					linha = buffer.readLine();
				}
				buffer.close();
				reader.close();
				flow.close();
				
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}  
		} else if (os.contains("Linux")){
			try {
				Process proc = Runtime.getRuntime().exec("ping -4 -c 10 www.google.com.br");
				InputStream flow = proc.getInputStream();
				InputStreamReader reader = new InputStreamReader(flow);
				BufferedReader buffer = new BufferedReader(reader);
				String linha = buffer.readLine();
				
				while (linha != null) {
					if (linha.contains("avg")) {
						String[] linhArray1 = linha.split("/");
						System.out.println(linhArray1[4]);
					}
					linha = buffer.readLine();
				}
				buffer.close();
				reader.close();
				flow.close();
				
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}
		}
	}
	
	/*public void callProcess(String process) {
		try {
			Runtime.getRuntime().exec(process);
		} catch (Exception e) {
			String msgErro = e.getMessage();
			System.err.println(msgErro);
			if (msgErro.contains("740")) {
				//cmd /c caminho_do_processo
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c ");
				buffer.append(process);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				e.printStackTrace();
			}
		}
	}*/
	
	/*public void readProcess(String process) {
		try {
			Process proc = Runtime.getRuntime().exec(process);
			InputStream flow = proc.getInputStream();
			InputStreamReader reader = new InputStreamReader(flow);
			BufferedReader buffer = new BufferedReader(reader);
			String linha = buffer.readLine();
			
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			
			buffer.close();
			reader.close();
			flow.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
}
	

