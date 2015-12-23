package com.defray.service;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.defray.action.RSASig;
import com.defray.model.DefrayRecordModel;

import com.opensymphony.xwork2.ActionSupport;



/**
 * 建行 支付处理
 * @author lcc
 *
 */
@Controller
@Scope("prototype")
public class ChinaConstructionBankpayService extends ActionSupport implements Serializable{

	private static final long serialVersionUID = -7144524630548398608L;
	private static Logger log = LoggerFactory.getLogger(ChinaConstructionBankpayService.class);

	@Autowired
	private DefrayRecordModel defrayRecordModel;
	
	private String strPubKey = "30819d300d06092a864886f70d010101050003818b00308187028181009ba4951169c5deecf03a8ddb2fd934f53747c03a211f63bccc84773182bdd8f7159634705041087e4c9053df05326952a143e1aab5e8ba75ed891a91c2db484b66a064abba6605418944d8763814ff23c161101948ec9ef2dfac735b4bb7c7dac18fbf87157b424780eb7080a3e7c9e79dd4841e44a001edfe497b9e3d2181b9020111";
	private String strPriKey = "30820277020100300d06092a864886f70d0101010500048202613082025d020100028181009ba4951169c5deecf03a8ddb2fd934f53747c03a211f63bccc84773182bdd8f7159634705041087e4c9053df05326952a143e1aab5e8ba75ed891a91c2db484b66a064abba6605418944d8763814ff23c161101948ec9ef2dfac735b4bb7c7dac18fbf87157b424780eb7080a3e7c9e79dd4841e44a001edfe497b9e3d2181b9020111028181008954fc004e452e1c5b7ef5a348563dc94ee4f4e7ff1bb25b4b0b783abea783345e575b7228b1da51529d772e31c311a342ffa90009eb7758fec4449ebafdb84126d1d2443dbcec07d9807638ef32cb91bf18eaaa46f6db84de5eba05edfe70ad029449a4cb4de7a95f5c903d6a3fa301f1cc0fe3e29ac72eeab68737f3b2f57d024100d428be0e1463c6b25cc493f23777135a9251b8092f3439c9604d61df8aadb958b947222fd60a489e5de44c379e806015edb0b15030a22cbc5e0ff693fd5bedcf024100bbce1eb6b55f5530f1bb7a437a0f0512f0153d0ada5c5b4ea57c3ea83bd89fe0166d5af1d07f153e83c05eae1585b113c03c8d989bb4d151c96aa78691fac1f7024100bb33020c6c5809ac6ff8bec6a9691113ae481adaed6a511b18bcbfc53e20d0b7b28a0f1b26454f2252d87f7c5ead81f53b236f46c180095ae9959d556714e0e3024100b0c1feca141d7d5b3ddda03f81f004c6879b84beeba237d18cb12be9a1bcd2b4c9d055984bc2e6d16cf14a0d416ec4c74b8449081a1397d48155526089647a51024100bcfe9b05b25578d5d96f80229e015aa58a0af5b0c0aa3ad695fe0d270c4818a737a7abc2f59cf1ea22c7155e06b7d26fba2594e29cb7fd02bd9b6e24b49e425a";

	//通知参数
	private String POSID;
	private String BRANCHID;
	private String ORDERID;
	private String PAYMENT;
	private String CURCODE;
	private String REMARK1;
	private String REMARK2;
	private String ACC_TYPE;
	private String SUCCESS;
	private String ACCDATE;
	private String SIGN;
	/**
	 * 支付同步回调
	 * @return
	 * @throws Exception 
	 */
	public String frontRcvResponse() throws Exception{
		return NONE;
	}
	
	/**
	 * 支付异步回调
	 * @return
	 * @throws Exception 
	 */
	public String backRcvResponse() throws Exception {
		/**
		 * POSID=000000000&BRANCHID=330000000&ORDERID=90712050000050576736&PAYMENT=50.00
		 * &CURCODE=01&REMARK1=&REMARK2=&ACC_TYPE=12&SUCCESS=Y&ACCDATE=20100907
		 * &SIGN=317b7dd349c1fbcabc26a20ba117a778da5a685c588be5e7378682651062a25b0885e36ee237c19a143f7271c9529a0e9bf198c8735709dc74233d96e1a276cec9d4835422bee597100b0a47d11b44dbba74bdf9cbde0587f138141ce79a3536733d5f6b53ed119c13708dca52ee8d3fcf7e67dcdb20053889adff1989a8c859
		 */
		StringBuffer sb = new StringBuffer();
		sb.append("POSID=").append(POSID).append("&BRANCHID=").append(BRANCHID)
				.append("&ORDERID=").append(ORDERID).append("&PAYMENT=")
				.append("PAYMENT").append("&CURCODE=").append(CURCODE)
				.append("&REMARK1=").append(REMARK1).append("&REMARK2=")
				.append(REMARK2).append("&ACC_TYPE=").append(ACC_TYPE)
				.append("&SUCCESS=").append(SUCCESS).append("&ACCDATE=")
				.append(ACCDATE);
		String strSrc = sb.toString();
		RSASig rsa = new RSASig();
		rsa.setPrivateKey(strPriKey);
		String strSign = rsa.generateSigature(strSrc);
		rsa.setPublicKey(strPubKey);
		if (rsa.verifySigature(strSign, strSrc)) {
			//验签通过
			
		} else {
			
		}

		
		return NONE;
	}
	
	/**
	 * 支付Order查询
	 * @return
	 */
	public String query(){
		return NONE;
	}
	
	/**
	 * 退款异步回调
	 * 
	 * @return
	 */
	public String asynchronousNoticeOfRefund() {
		return NONE;
	}
	
	/**
     * 获得response
     */
    private HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }
    
    /**
     * 获得request
     */
    private HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

	public String getPOSID() {
		return POSID;
	}

	public void setPOSID(String pOSID) {
		POSID = pOSID;
	}

	public String getBRANCHID() {
		return BRANCHID;
	}

	public void setBRANCHID(String bRANCHID) {
		BRANCHID = bRANCHID;
	}

	public String getORDERID() {
		return ORDERID;
	}

	public void setORDERID(String oRDERID) {
		ORDERID = oRDERID;
	}

	public String getPAYMENT() {
		return PAYMENT;
	}

	public void setPAYMENT(String pAYMENT) {
		PAYMENT = pAYMENT;
	}

	public String getCURCODE() {
		return CURCODE;
	}

	public void setCURCODE(String cURCODE) {
		CURCODE = cURCODE;
	}

	public String getREMARK1() {
		return REMARK1;
	}

	public void setREMARK1(String rEMARK1) {
		REMARK1 = rEMARK1;
	}

	public String getREMARK2() {
		return REMARK2;
	}

	public void setREMARK2(String rEMARK2) {
		REMARK2 = rEMARK2;
	}

	public String getACC_TYPE() {
		return ACC_TYPE;
	}

	public void setACC_TYPE(String aCC_TYPE) {
		ACC_TYPE = aCC_TYPE;
	}

	public String getSUCCESS() {
		return SUCCESS;
	}

	public void setSUCCESS(String sUCCESS) {
		SUCCESS = sUCCESS;
	}

	public String getACCDATE() {
		return ACCDATE;
	}

	public void setACCDATE(String aCCDATE) {
		ACCDATE = aCCDATE;
	}

	public String getSIGN() {
		return SIGN;
	}

	public void setSIGN(String sIGN) {
		SIGN = sIGN;
	}
	
    
    
}
