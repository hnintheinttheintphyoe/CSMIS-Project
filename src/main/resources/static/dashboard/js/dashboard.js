$('.counterup').counterUp({
    delay: 10,
    time: 1000
});
let month=['Jan','Feb','March','April','May','Jun','July','Aug','Sept','Oct','Dec'];
let userData=[15,20,60,40,25,50,35,75,65,35,55,60];
let viewerData=[8,10,12,9,10,16,7,39,21,7,6,5];
let ctx = document.getElementById('ov').getContext('2d');
let myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: month,
        datasets: [{
            label: 'User of Votes',
            lineTension: 0, 
            data: userData,
            backgroundColor: [
                '#007bff30',
                
            ],
            borderColor: [
                '#007bff',
                
            ],
            borderWidth: 1,
            
        },
        {
            label: 'Viewer of Votes',
            lineTension: 0, 
            data: viewerData,
            backgroundColor: [
                '#6c757d30',
                
            ],
            borderColor: [
                '#6c757d',
                
            ],
            borderWidth: 1,
            
        }
    ]
    },
    options: {
        scales: {
            // y: {
            //     beginAtZero: true
            // },
            yAxes: [{
                display:false,
                gridLines: {
                    display:false
                }
                
            }],
            xAxes: [{
                display:false,
                gridLines: {
                    display:false
                }
            }],
              },
              legend: {
                display: true,
                position: 'top',
                labels: {
                    fontColor: "#6c757d",
                    usePointStyle:true
                  }
                
        }
    }
    
});
let dataFromTo=[10,15,11,11,7];
let place=['YGN','MDY','NPT','MGY','PKU'];
const op = document.getElementById('op').getContext('2d');
const myop = new Chart(op, {
    type: 'doughnut',
    data: {
        labels: place,
        datasets: [{
            label: '# of Votes',
            data: dataFromTo,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        },
        legend: {
            display: true,
            position: 'top',
            labels: {
                fontColor: "#6c757d",
                usePointStyle:true
              }
    }
}
});


