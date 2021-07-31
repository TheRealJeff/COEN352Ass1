package coen352ass1;

public class BinRecord {
	private String binNum;
	private String description;
	private String location;
	private long width;
	private long height;
	private long length;
	
	// constructors
	public BinRecord()
	{
		binNum = "";
		description = "";
		location = "";
		width = 0;
		height = 0;
		length = 0;
	}
	public BinRecord(String num, String dsc, String loc, long wi, long hg, long le)
	{
		binNum = num;
		description = dsc;
		location = loc;
		width = wi;
		height = hg;
		length = le;
	}

	// getters
	public String getBinNum()
	{
		return binNum;
	}
	public String getDescription()
	{
		return description;
	}
	public String getLocation()
	{
		return location;
	}
	public long getWidth()
	{
		return width;
	}
	public long getHeight()
	{
		return height;
	}
	public long getLength()
	{
		return length;
	}

	// setters
	public void setBinNum(String num)
	{
		binNum = num;
	}
	public void setDescription(String dsc)
	{
		description = dsc;
	}
	public void setLocation(String loc)
	{
		location = loc;
	}
	public void setWidth(long wi)
	{
		width = wi;
	}
	public void setHeight(long hg)
	{
		height = hg;
	}
	public void setLength(long len)
	{
		length = len;
	}

	public boolean sameAs(BinRecord toCompare)
	{
		return 
		(binNum == toCompare.binNum) &&
		(description == toCompare.description) &&
		(location == toCompare.location) &&
		(width == toCompare.width) &&
		(height == toCompare.height) &&
		(length == toCompare.length); 
		// return true if two BinRecords are identical
	}
}
