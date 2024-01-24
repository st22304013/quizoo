
let historyList;
window.addEventListener('load', async () => {
	historyList = await fetch("/quizoo/answerhistory", {
		credentials: "include"
	});
	historyList = await historyList.json();
	console.log(historyList);
	
	for(var i = 0; i < historyList.length; i++) {
		var correctCount = historyList[i].correctCount;
		var questionCount = historyList[i].questionCount;

		var rate = correctCount / questionCount;
		console.log(rate);

		config.data.datasets[0].data.push(rate);
		config.data.labels.push(correctCount);
	}

	const ctx = document.getElementById('chart').getContext('2d');
	const myChart = new Chart(ctx, config);
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
			},
			title: {
				display: true,
				text: 'グラフ'
			}
		}
	}
};


