
let historyList;
window.addEventListener('load', async () => {
	historyList = await fetch("/quizoo/answerhistory", {
		credentials: "include"
	});
	historyList = await historyList.json();

	let correctCount = 0;
	let questionCount = 0;
	// 正解率をだすfor文
	for(var i = 0; i < historyList.length; i++) {
		
		correctCount += historyList[i].correctCount;
		questionCount += historyList[i].questionCount;
		var quizCount = i+1;

		var correctRate = (correctCount / questionCount) * 100;
		config.data.datasets[0].data.push(correctRate);
		config.data.labels.push(quizCount);
		console.log("正解数"+correctCount);
		console.log("質問数："+questionCount)
		console.log("クイズ数："+quizCount);
		console.log("率："+correctRate);

		var rate = (correctCount * correctCount) / questionCount; 
		config2.data.datasets[0].data.push(rate);
		config2.data.labels.push(quizCount);

	}
	// 正解率のChart 
	const ctx = document.getElementById('chart').getContext('2d');
	const myChart = new Chart(ctx, config);
	document.getElementById('rate').innerHTML = 'レート ' + rate;


	// レートのChart 
	const ctx2 = document.getElementById('chart2').getContext('2d');
	const myChart2 = new Chart(ctx2, config2);
	document.getElementById('correctRate').innerHTML = '正解率 ' + correctRate + '%';
});

let config = {
	type: 'line',
	data: {
		labels: [],
		datasets: [
			{
				label: '正解率',
				data: [],
				borderColor: 'rgba(255, 99, 132, 1)',
				backgroundColor: 'rgba(255, 99, 132, 0.2)',
			},	          // ... 追加の datasets
		]
	},
	options: {
		responsive: true,
		plugins: {
			legend: {
				position: 'top',
				labels: {
					usePointStyle: true,
				},
			},
			title: {
				display: true,
			}
		},
		scales: {
			x: {
				min:0,
				stepSize: 1,
				title: {
					display: true,
					text: '回答数',
				},
			},
			y: {				   
				min:0,
				max:100,
				stepSize: 1,
				title: {
					display: true,
					text: '正答率(%)',
					padding: {
						top: 0,
						bottom: 0,
					},
				},	
			}
		}
	}
};


let config2 = {
	type: 'line',
	data: {
		labels: [],
		datasets: [
			{
				label: 'レーティング',
				data: [],
				borderColor: 'rgba(255, 99, 132, 1)',
				backgroundColor: 'rgba(255, 99, 132, 0.2)',
			},
		]
	},
	options: {
		responsive: true,
		plugins: {
			legend: {
				position: 'top',
				labels: {
					usePointStyle: true,
				},
			},
			title: {
				display: true,
			}
		},
		scales: {
			x: {
				min:0,
				stepSize: 1,
				title: {
					display: true,
					text: '回答数',
				},
			},
			y: {				   
				min:0,
				stepSize: 1,
				title: {
					display: true,
					text: 'レート',
					padding: {
						top: 0,
						bottom: 0,
					},
				},	
			}
		}
	}
};

