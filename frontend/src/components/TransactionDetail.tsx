

interface TransactionDetailProps{
 image:string;
 itemName:string;
 shopName:string;
 amount:number;
 date:string;
}
const TransactionDetail = ({image,itemName,shopName,amount,date}:TransactionDetailProps) => {
  return (
    <div className=" w-full flex justify-between items-center">
        <div className=" flex gap-3">
            <div className=" h-10 w-10 bg-light-gray-3 rounde-[8px] flex items-center justify-center self-start">
                <img 
                src={image} 
                height={24}
                width={24}
                alt="" />
            </div>
            <div className=" flex flex-col ">
                <h3 className="font-inter font-semibold text-[16px] text-dark-1">{itemName}</h3>
                <p className="font-inter font-normal text-[14px] text-light-gray-4">{shopName}</p>
            </div>


        </div>
        <div className="block justify-end">
           <p className="font-inter font-semibold text-[16px] text-dark-2">${amount}</p>
           <p className=" font-inter font-normal text-sm text-light-gray-4">{date}</p>
        </div>
    </div>
  )
}

export default TransactionDetail