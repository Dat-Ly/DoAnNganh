<%-- 
    Document   : thongke
    Created on : Oct 15, 2022, 3:36:45 PM
    Author     : datly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1 class="text-center">THỐNG KÊ</h1>
<div>
  <canvas id="myChart"></canvas>
</div>
<table class="table">
    <tr>
        <th>Tháng</th>
        <th>Tổng tiền</th>
    </tr>
    <c:forEach items="${thongke}" var="t">
        <tr>
            <td>${t[0]}/${t[1]}</td>
            <td>${t[2]}</td>
        </tr>
    </c:forEach>
    
</table>
<script>

    function thongKe(id, cateLabels=[], cateInfos=[]){
   const labels = ["January","February","March","April","May","June","July","August","September","October","November","December"]
    const data = {
  labels: cateLabels,
  datasets: [{
    label: 'Thống kê doanh thu từng tháng',
    data: cateInfos,
    backgroundColor: [
      'rgba(255, 99, 132, 0.2)',
      'rgba(255, 159, 64, 0.2)',
      'rgba(255, 205, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(201, 203, 207, 0.2)'
                    ],
                    borderColor: [
                        'rgb(255, 99, 132)',
                        'rgb(255, 159, 64)',
                        'rgb(255, 205, 86)',
                        'rgb(75, 192, 192)',
                        'rgb(54, 162, 235)',
                        'rgb(153, 102, 255)',
                        'rgb(201, 203, 207)'
                    ],
                    borderWidth: 1
                }]
        };
                const config = {
  type: 'bar',
  data: data,
  options: {
    scales: {
      y: {
        beginAtZero: true
      }
    }
  },
};
let ctx = document.getElementById("myChart").getContext("2d")
new Chart(ctx, config)
}
    let cateLabels=[], cateInfos=[];
    <c:forEach items="${thongke}" var="t">
        cateLabels.push('${t[0]}/${t[1]}')
        cateInfos.push('${t[2]}')
    </c:forEach>

     window.onload=function(){
     thongKe("myChart",cateLabels,cateInfos)
 }
</script>


