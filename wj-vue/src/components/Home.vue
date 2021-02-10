<template>
    <div class="indexPage">
      <nav-menu></nav-menu>
      <router-view/>
    </div>
</template>

<script>
    import NavMenu from "@/components/common/NavMenu";
    export default {
      name: "Home",
      components: {NavMenu}
    }
</script>

<style scoped>
  .indexPage{
    height: 800px;
  }
</style>
