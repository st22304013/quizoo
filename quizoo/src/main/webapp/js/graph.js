
let historyList;
window.addEventListener('load', async () => {
	historyList = await fetch("/quizoo/answerhistory", {
		credentials: "include"
	});
	historyList = await historyList.json();
	console.log(historyList);
	let correctCount = 0;
	let questionCount = 0;
	// 正解率をだすfor文
	for(var i = 0; i < historyList.length; i++) {
		
		correctCount += historyList[i].correctCount;
		questionCount += historyList[i].questionCount;
		var quizCount = i;

		var correctRate = (correctCount / questionCount) * 100;
		config.data.datasets[0].data.push(correctRate);
		config.data.labels.push(quizCount);

		var rate = (correctCount * correctCount) / questionCount; 
		config2.data.datasets[0].data.push(rate);
		config2.data.labels.push(quizCount);
		console.log(rate);
	}
	// スコアのChart 
	const ctx = document.getElementById('chart').getContext('2d');
	const myChart = new Chart(ctx, config);

	// レートのChart 
	const ctx2 = document.getElementById('chart2').getContext('2d');
	const myChart2 = new Chart(ctx2, config2);

});

let config = {
	type: 'line',
	data: {
		labels: [],
		datasets: [
			{
				label: 'score',
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
				text: 'グラフ'
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
				text: 'グラフ'
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

