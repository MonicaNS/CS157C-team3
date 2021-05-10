import React, { forwardRef, useState, useEffect } from 'react'
import MaterialTable from "material-table";

import AddBox from '@material-ui/icons/AddBox';
import ArrowDownward from '@material-ui/icons/ArrowDownward';
import Check from '@material-ui/icons/Check';
import ChevronLeft from '@material-ui/icons/ChevronLeft';
import ChevronRight from '@material-ui/icons/ChevronRight';
import Clear from '@material-ui/icons/Clear';
import DeleteOutline from '@material-ui/icons/DeleteOutline';
import Edit from '@material-ui/icons/Edit';
import FilterList from '@material-ui/icons/FilterList';
import FirstPage from '@material-ui/icons/FirstPage';
import LastPage from '@material-ui/icons/LastPage';
import Remove from '@material-ui/icons/Remove';
import SaveAlt from '@material-ui/icons/SaveAlt';
import Search from '@material-ui/icons/Search';
import ViewColumn from '@material-ui/icons/ViewColumn';
import { List } from '@material-ui/core';

const tableIcons = {
    Add: forwardRef((props, ref) => <AddBox {...props} ref={ref} />),
    Check: forwardRef((props, ref) => <Check {...props} ref={ref} />),
    Clear: forwardRef((props, ref) => <Clear {...props} ref={ref} />),
    Delete: forwardRef((props, ref) => <DeleteOutline {...props} ref={ref} />),
    DetailPanel: forwardRef((props, ref) => <ChevronRight {...props} ref={ref} />),
    Edit: forwardRef((props, ref) => <Edit {...props} ref={ref} />),
    Export: forwardRef((props, ref) => <SaveAlt {...props} ref={ref} />),
    Filter: forwardRef((props, ref) => <FilterList {...props} ref={ref} />),
    FirstPage: forwardRef((props, ref) => <FirstPage {...props} ref={ref} />),
    LastPage: forwardRef((props, ref) => <LastPage {...props} ref={ref} />),
    NextPage: forwardRef((props, ref) => <ChevronRight {...props} ref={ref} />),
    PreviousPage: forwardRef((props, ref) => <ChevronLeft {...props} ref={ref} />),
    ResetSearch: forwardRef((props, ref) => <Clear {...props} ref={ref} />),
    Search: forwardRef((props, ref) => <Search {...props} ref={ref} />),
    SortArrow: forwardRef((props, ref) => <ArrowDownward {...props} ref={ref} />),
    ThirdStateCheck: forwardRef((props, ref) => <Remove {...props} ref={ref} />),
    ViewColumn: forwardRef((props, ref) => <ViewColumn {...props} ref={ref} />)
  };


export default function ViewInventory() { 
    const [dataFromDB, setDataFromDB] = useState([])
    const [inventoryData, setInventoryData] = useState([])
    const [expiryDates, setExpiryDates] = useState([])

    useEffect(()=> {
        const urlToFetchData = "http://localhost:8094/inventory/getAll"
        fetch(urlToFetchData)
        .then(res => res.json())
        .then(data => {
            setDataFromDB(data)
        })
    },[])

    useEffect(()=> {
        const tempData = dataFromDB
        {tempData.map((object,i)=> {
            object.index = i + 1
        })}
        setInventoryData(tempData)
    },[dataFromDB])

    useEffect(()=>{
        console.log(inventoryData)
        let hashMap = new Map()
        inventoryData.map((obj,i)=>{
            let list = []
            obj.expiration.map(exp =>{
                let expDate = `${exp.expiry_date} : ${exp.quantity}`
                list.push(expDate)
            })
            hashMap.set(obj.name,list)
        })
        setExpiryDates(hashMap)
    },[inventoryData])

    const handleSubmit = (e) => {
        e.preventDefault()
        let finalData = []
        finalData["order_date"] = new Date()
        finalData["items"] = inventoryData
        const urlToSendData = "http://localhost:8094/wholesale/getAll"
        fetch(urlToSendData, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(finalData)
        })    
    }


    const updateData = (newValue,rowIndex) => {
        const index = rowIndex - 1
        let newData = [...inventoryData]
        newData[index].price = newValue
        setInventoryData(newData)
    }

    return(
        <div className="restock-inventory"> 
            <div style={{ maxWidth: "900%",marginLeft:"2em",marginRight:"1em", paddingTop:"2em"}}>
                <MaterialTable
                options={{
                    paging:true,
                    pageSize:9,
                    searchAutoFocus: true
                }}
                icons={tableIcons}
                cellEditable={{
                    cellStyle: {},
                    onCellEditApproved: (newValue, oldValue, rowData, columnDef) => {
                        return new Promise((resolve, reject) => {
                            setTimeout(resolve, 1000);
                            updateData(newValue,rowData.index)
                        });
                    }
                }}
                columns={[
                { title: "No.", field: "index", type:"string", editable:"never"},
                { title: "Name", field: "name", type:"string", editable:"never"},
                { title: "Price", field: "price", editable:"always"},
                ]}
                data={inventoryData}
                title="Buy Items"
                detailPanel={rowData => {
                    return (
                        <div
                            style={{
                            marginLeft: 80,
                            fontSize: 16,
                            textAlign: 'left',
                            color: 'black',
                            backgroundColor: 'white',
                            }}
                        >
                            {expiryDates.get(rowData.name).map(obj =>{
                                    {console.log(rowData.name)}
                                    {console.log(obj)}
                                    return(
                                        <div>
                                        {obj}
                                    </div>
                                    )
                                })}
                        </div>
                        )
                }}
                onRowClick={(event, rowData, togglePanel) => togglePanel()}
                />
        </div>
        <button onClick={e=>handleSubmit(e)}>Submit</button>
      </div>
    )
}

