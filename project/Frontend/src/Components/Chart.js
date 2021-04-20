import { Chart } from "react-google-charts";

export default function StatsChart() {
    return(
        <div className="chart-card">
            <Chart
                width={'23em'}
                height={'16.8em'}
                chartType="PieChart"
                loader={<div>Loading Chart</div>}
                data={[
                    ['Action', 'Revenue'],
                    ['Sales', 70],
                    ['Theft', 10],
                    ['Waste', 20],
                ]}
                options={{
                    title: 'Financial Chart',
                    sliceVisibilityThreshold: 0.09, // 20%
                }}
                rootProps={{ 'data-testid': '7' }}
            />
        </div>
    )
}