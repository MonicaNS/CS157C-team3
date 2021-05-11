import { Chart } from "react-google-charts";

export default function LineChart({dataset}){
    return (
        <div style={{maxWidth: "200%", marginLeft:"500px", marginRight:"100px", paddingTop:"80px", paddingRight:"100px"}}>
        <Chart
            width = {'600px'}
            height = {'400px'}
            chartType = "LineChart"
            loader = {<div>Loading Chart</div>}
            data = {[
                    ['x', 'NetIncome', 'Time'],
                    [0, 0, 0],
                    [1, dataset[0].productSoldDay, dataset[0].productBoughtDay],
                    [2, dataset[1].productSoldDay, dataset[1].productBoughtDay],
                    [3, dataset[2].productSoldDay, dataset[2].productBoughtDay]

                ]}
            
            options = {{
                hAxis: {
                title: 'Time',},

                vAxis: {
                title: 'Net Income',},

                series: {
                    1: { curveType: 'function' },
                    },
                }}
                rootProps = {{ 'data-testid': '2' }}
        />
        </div>
    )
    
}

