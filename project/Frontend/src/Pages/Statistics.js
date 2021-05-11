import React, {useState, useEffect} from 'react'
import LineChart from '../Components/statisticsChart'
import BarChart from '../Components/BarChart'

export default function Statistics(){  

    const[newDataSet, setNewDataSet] = useState([])
    const[finalDataSet, setFinalDataSet] = useState([])

    useEffect(()=> {
        const urlToFetchData = "http://localhost:8094/revenue/barGraph"
        fetch(urlToFetchData)
        .then(res => res.json())
        .then(data => {
            setNewDataSet(data)
        })
    },[])

    useEffect(()=> {
        const finalArray = []
        newDataSet.map(object => {
            const itemName = object.itemName
            const data = object.data
            const profit = data[0]
            const expense = data[1]
            const item = {
                itemName: itemName,
                profit: profit,
                expense: expense
            }
            finalArray.push(item)
        })
        setFinalDataSet(finalArray)
        
    },[newDataSet])

    return(
        <div className="Statistics">
         <BarChart finalDataSet = {finalDataSet} style = {{"width":"300px"}}/>                            
        </div>
    
    )

}

