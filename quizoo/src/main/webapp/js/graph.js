
console.log("start");



let historyList;
window.addEventListener('load', async () => {
	historyList = await fetch("/quizoo/answerhistory", {
		credentials: "include"
	});
	historyList = await historyList.json();
	console.log(historyList);
	
	// グラフの初期化処理
	document.addEventListener('DOMContentLoaded', function () {
		const ctx = document.getElementById('chart').getContext('2d');
		const myChart = new Chart(ctx, config);
	});

	data.labels = historyList.quizId;

});

const config = {
	type: 'line',
	data: {
		labels: ["Label 1", "Label 2", "Label 3", "Label 4"],
		datasets: [
			{
				label: 'score',
				data: [10, 20, 30, 50],
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


const data = {
	labels: null,
	datasets: [
		{
			label: 'score',
			data: [50, 20, 30, 40],
			borderColor: 'rgba(0,0,0)',
			backgroundColor: 'rgba(255, 99, 132, 0.2)',
		},
	]
};

console.log("end");