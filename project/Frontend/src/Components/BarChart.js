import { useEffect, useState } from "react";
import { Chart } from "react-google-charts";

export default function BarChart({finalDataSet}){
    const [data, setData ] = useState([])

    useEffect(()=>{
        const tempArray = []
        tempArray.push(['Item Name', 'Total Spent', 'Net Income'])
        finalDataSet.map(object=>{
            const t = []
            t.push(object.itemName)
            t.push(object.expense)
            t.push(object.profit)
            tempArray.push(t)
        })
        setData(tempArray)
    },[finalDataSet])
    
    return (
        <div style={{maxWidth: "500%", marginLeft:"300px", marginRight:"100px", paddingTop:"50px"}}>
        <Chart
        width={'1000px'}
        height={'700px'}
        chartType="Bar"
        loader={<div>Loading Chart</div>}
        data = {data}
        options={{
            // Material design options
            chart: {
            title: 'Weekly Net Income',
            subtitle: 'Expenses, and Profit: May 2021',
            },
        }}
        // For tests
        rootProps={{ 'data-testid': '2' }}
    />
    </div>

    )
    
}