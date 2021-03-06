import React, {Component, PropTypes} from 'react';
import {Bar} from 'react-chartjs-2';


export default class BarChart extends Component{
    render() {
         const data = {
           labels: this.props.labels,
           datasets: [
             {
            label: this.props.label,
            backgroundColor: this.props.backgroundColor,
            borderColor: this.props.borderColor,
            borderWidth: 1,
            data: this.props.values,
        }
    ]
};

const options = {
        scales: {
            xAxes: [{
                stacked: true
            }],
            yAxes: [{
                stacked: true,
                ticks: {
                    beginAtZero:true
                }
            }]
        }
};


        return (
            <div className="col-md-12 container">
                <Bar ref='data' data = {data} options={options}/>
            </div>
            );
        }
};

BarChart.propTypes = {
  values: PropTypes.array,
  labels: PropTypes.array,
  label: PropTypes.string,
  backgroundColor : PropTypes.array,
  borderColor: PropTypes.array,
};
