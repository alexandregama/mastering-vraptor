<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	sessionOpenCount: ${statistic.sessionOpenCount} <br/>
	
	sessionCloseCount: ${statistic.sessionCloseCount} <br/>
	
	collectionFetchCount: ${statistic.collectionFetchCount} <br/>
	
	entityFetchCount: ${statistic.entityFetchCount} <br/>
	
	connectCount: ${statistic.connectCount} <br/>
	
	entityFetchCount: ${statistic.entityFetchCount} <br/>
	
	flushCount: ${statistic.flushCount} <br/>
	
	queryCacheHitCount: ${statistic.queryCacheHitCount} <br/>
	
	queryCacheMissCount: ${statistic.queryCacheMissCount} <br/>
	
	secondLevelCacheHitCount: ${statistic.secondLevelCacheHitCount} <br/>
	
	secondLevelCacheMissCount: ${statistic.secondLevelCacheMissCount} <br/>
	
	transactionCount: ${statistic.transactionCount} <br/>
</body>
</html>