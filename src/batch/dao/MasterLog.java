package batch.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;

public class MasterLog {

	private String host;
	private String user;
	private Date requestTime;
	private String path;
	private Integer code;
	private String referer;
	private String agent;
	private String xff;
	private List<Integer> creativeIdList = new ArrayList<Integer>();
	private String dispcid;
	private Nation nw;
	private Site site;
	private Integer advertiserId;
	private Integer advertiseId;
	private Integer responseTime;
	private Integer responseSize;
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getXff() {
		return xff;
	}

	public void setXff(String xff) {
		this.xff = xff;
	}

	public List<Integer> getCreativeIdList() {
		return creativeIdList;
	}

	public void setCreativeIdList(List<Integer> creativeIdList) {
		this.creativeIdList = creativeIdList;
	}

	public void addCreativeId(Integer creativeId) {
		creativeIdList.add(creativeId);
	}
	
	public String getDispcid() {
		return dispcid;
	}

	public void setDispcid(String dispcid) {
		this.dispcid = dispcid;
	}

	public Nation getNw() {
		return nw;
	}

	public void setNw(Nation nw) {
		this.nw = nw;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Integer getAdvertiserId() {
		return advertiserId;
	}

	public void setAdvertiserId(Integer advertiserId) {
		this.advertiserId = advertiserId;
	}

	public Integer getAdvertiseId() {
		return advertiseId;
	}

	public void setAdvertiseId(Integer advertiseId) {
		this.advertiseId = advertiseId;
	}

	public Integer getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Integer responseTime) {
		this.responseTime = responseTime;
	}

	public Integer getResponseSize() {
		return responseSize;
	}

	public void setResponseSize(Integer responseSize) {
		this.responseSize = responseSize;
	}

	public MasterLog(JSONObject jo) {
		this.agent = (String) jo.get("agent");
	}
}
