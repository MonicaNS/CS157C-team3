import React from 'react'

export default function Dashboard() {
    return(
        <div className="dashboard">
            <div className="title-container">
                Inventory Management
            </div>
            <div className="button-container">
                <button className="box-1">
                    Inventory
                </button>
                <button className="box-2">
                    Restock 
                </button>
                <button className="box-3">
                    Statistics 
                </button>
            </div>
        </div>
    ) 
}