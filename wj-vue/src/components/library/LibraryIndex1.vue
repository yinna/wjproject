<template>
    <el-container>
      <el-aside style="width: 200px;margin-top: 20px">
        <side-menu>
        </side-menu>
      </el-aside>
      <el-main>
        <books1 class="books-area"></books1>
      </el-main>
    </el-container>
</template>

<script>
    import SideMenu from "@/components/library/SideMenu";
    import Books1 from "@/components/library/Books1";
    export default {
        name: "LibraryIndex1",
      components: {Books1, SideMenu}
    }
</script>

<style scoped>
  .books-area{
    width: 990px;
    margin-left: auto;
    margin-right: auto;
  }
</style>
