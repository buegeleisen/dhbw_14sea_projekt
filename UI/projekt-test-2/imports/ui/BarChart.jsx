import React, {Component, PropTypes} from 'react';
import {Bar} from 'react-chartjs-2';


export default class LineChart extends Component{
    render() {
         const data = {
           labels: this.props.labels,
           datasets: [
             {
            label: "My First dataset",
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1,
            data: this.props.values,
        }
    ]
};



        return (
            <div className="col-md-12 container">
                <Bar ref='data' data = {data}/>
            </div>
            );
        }
};

LineChart.propTypes = {
  values: PropTypes.array,
  labels: PropTypes.array,
  labelName: PropTypes.string
};
