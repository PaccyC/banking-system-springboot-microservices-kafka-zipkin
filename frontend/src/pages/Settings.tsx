import { useState } from "react"
import {
  Tabs,
  TabsContent,
  TabsList,
  TabsTrigger,
} from "../components/ui/tabs"
import { Button } from "../components/ui/button"

const Settings = () => {
  const [selectedTab, setSelectedTab] = useState("account")

  const handleSelectTab = (tabName: string) => {
    setSelectedTab(tabName)
  }

  return (
    <div className="bg-white h-[90%] rounded-[8px] w-full p-6 flex justify-between">
      <Tabs 
            value={selectedTab} 
            onValueChange={handleSelectTab} 
            className="w-full flex flex-col gap-8">
        <TabsList className="grid grid-cols-2 w-[400px] mb-4">
          <TabsTrigger 
            
            value="account"
          >
             <p className={`font-inter font-bold text-[16px] shadow-none ${selectedTab === "account" ? "text-primary-1 active-link " : "text-light-gray-4"}`}>Account</p>
          </TabsTrigger>
          <TabsTrigger 
            value="password"
          >
            <p className={`font-inter font-bold text-[16px] shadow-none ${selectedTab === "password" ? "text-primary-1  active-link shadow-none bg-transparent" : "text-light-gray-4"}`}> Security</p>
          </TabsTrigger>
        </TabsList>

        <TabsContent value="account">
           <div className="p-0 flex gap-8 flex-col">
            <div className=" flex flex-col gap-6">
                <h3 className=" text-dark-3 font-medium text-2xl font-inter">Full name</h3>
                <p className=" text-light-gray-4 font-semibold font-inter pl-6">Tanzir Rahman</p>
            </div>
            <div className=" flex flex-col gap-6">
                <h3 className=" text-dark-3 font-medium text-2xl font-inter">Email</h3>
                <p className=" text-light-gray-4 font-semibold font-inter pl-6">tanzirrahman@gmail.com</p>
            </div>
            <div className=" flex flex-col gap-6">
                <h3 className=" text-dark-3 font-medium text-2xl font-inter">Username</h3>
                <p className=" text-light-gray-4 font-semibold font-inter pl-6">tanzirrahman</p>
            </div>
            <div className=" flex flex-col gap-6">
                <h3 className=" text-dark-3 font-medium text-2xl font-inter">Phone Number</h3>
                <p className=" text-light-gray-4 font-semibold font-inter pl-6">+123 74393287381092</p>
            </div>

            <Button className=" bg-primary-1 text-white font-semibold font-inter rounded-[4px] px-4 py-3 text-center max-w-[200px] hover:bg-primary-1">Update Profile</Button>
           </div>
        </TabsContent>

        <TabsContent value="password">
        <div className="p-0 flex gap-8 flex-col">
            <div className=" flex flex-col gap-6">
                <h3 className=" text-dark-3 font-medium text-2xl font-inter">Old Password</h3>
                <p className=" text-light-gray-4 font-semibold font-inter pl-6">*************</p>
            </div>
            <div className=" flex flex-col gap-6">
                <h3 className=" text-dark-3 font-medium text-2xl font-inter">New Password</h3>
                <p className=" text-light-gray-4 font-semibold font-inter pl-6">*************</p>
            </div>
            <div className=" flex flex-col gap-6">
                <h3 className=" text-dark-3 font-medium text-2xl font-inter">Retype Password</h3>
                <p className=" text-light-gray-4 font-semibold font-inter pl-6">*************</p>
            </div>
            <div className=" flex flex-col gap-6">
                <h3 className=" text-dark-3 font-medium text-2xl font-inter">Phone Number</h3>
                <p className=" text-light-gray-4 font-semibold font-inter pl-6">+123 74393287381092</p>
            </div>

            <Button className=" bg-primary-1 text-white font-semibold font-inter rounded-[4px]  text-center max-w-[200px] hover:bg-primary-1">Update Password</Button>
        </div>
        </TabsContent>
      </Tabs>
      {
        selectedTab === "account" && 
        <div></div>
      }
    </div>
  )
}

export default Settings
