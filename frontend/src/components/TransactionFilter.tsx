import { useState } from "react";
import { transactionLinks } from "../utils/transactionLinks"

const TransactionFilter = () => {
    const [isSelected,setIsSelected]= useState("");
    const handleClick =(value:string)=>{
      setIsSelected(value)
  
    }
  return (
    <ul className=" flex gap-6">
          {transactionLinks.map((link)=>(
        
          <li 
          onClick={()=>handleClick(link.name)}
          className={` text-dark-2 cursor-pointer font-inter font-bold text-[16px] ${isSelected === link.name ? "active-link text-primary-1":""}`}
          key={link.type}>{link.name}</li>
         
          ))}
         </ul>
  )
}

export default TransactionFilter