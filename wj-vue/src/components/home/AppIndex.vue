<template>
  <div style="margin-top: 40px">
    <SideMenu id="side-menu"></SideMenu>
    <div class="home">
      <div id="header-div">
        <div style="height: 150px"></div>
        <carousel></carousel>
        <quick-nav style="float: right;margin-top: -450px;margin-right: 480px"></quick-nav>
      </div>
      <update-card id="update-card"></update-card>
      <slogan id="slogan"></slogan>
      <about id="about"></about>
      <el-button class="btn" v-on:click="menu">resr</el-button>
    </div>
  </div>
</template>

<script>
    import SideMenu from "@/components/home/SideMenu"
    import Carousel from "@/components/home/Carousel"
    import UpdateCard from "@/components/home/UpdateCard"
    import QuickNav from "@/components/home/QuickNav"
    import Slogan from "@/components/home/Slogan"
    import About from "@/components/common/About"
    export default {
      name: "Appindex",
      components: {SideMenu,Carousel,UpdateCard,QuickNav,Slogan,About},
      methods:{
        menu(){
          this.$axios.get("/menu").then(resp => {
            console.log(resp)
          })
        }
      }
    }
</script>

<style scoped>
  .home {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
    margin-top: -20px;
  }
  #header-div {
    padding-bottom: 20px;
    padding-left: 5px;
    background-color: white;
  }
  #side-menu {
    position: fixed;
    margin-left: 50%;
    left: 50px;
    top: 100px;
  }
</style>
