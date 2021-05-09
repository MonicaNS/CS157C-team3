import React from 'react'
import LineChart from '../Components/statisticsChart'

export default function Statistics(){  
    const dataset= 
            [
                {
                    productSoldDay: 5,
                    productBoughtDay: 10 
                },

                {
                    productSoldDay: 5,
                    productBoughtDay: 10 
                },

                {
                    productSoldDay: 5,
                    productBoughtDay: 10 
                },

                // {
                //     productSoldDay: 5,              
                //     productBoughtDay: 10 
                // },

                // {   
                //     productSoldDay: 5,
                //     productBoughtDay: 10 
                // },

                // {
                //     productSoldDay: 5,
                //     productBoughtDay: 10
                // },

                // {
                //     productSoldDay: 5,
                //     productBoughtDay: 10 
                // },
            ]

    return(
        <div className="Statistics">
         <LineChart dataset ={dataset} style={{"marginLeft":"800px"}}/>          
        </div>
    
    )

}

