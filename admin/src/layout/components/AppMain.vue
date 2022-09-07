<template>
  <section class="app-main">
    <transition name="fade-transform" mode="out-in">
      <keep-alive :include="cachedViews">
        <router-view :key="key" />
      </keep-alive>
    </transition>
    <div class="footers">
      <el-link v-for="item in links" :key="item.key" :href="item.href" target="_blank" class="mr15 mb20">{{item.title}}</el-link>
      <div class="title mb15" v-text="copyright"></div>
    </div>
  </section>
</template>

<script>
export default {
  name: 'AppMain',
  data () {
    return {
      links: [
        {
          title: '舒洪凡的Github',
          key: '1',
          href: 'https://github.com/shuhongfan',
          blankTarget: true
        },
        {
          title: '凡购商城GITHUB',
          key: '2',
          href: 'https://github.com/shuhongfan/CRMEB_Demo01',
          blankTarget: true
        }
      ],
      copyright: 'Copyright © 2022 shuhongfan'
    }
  },
  computed: {
    cachedViews() {
      return this.$store.state.tagsView.cachedViews
    },
    key() {
      return this.$route.path
    }
  }
}
</script>

<style lang="scss" scoped>
  .footers{
    text-align: center;
    font-size: 14px;
    color: #808695;
    .title{
      font-size: 14px;
      color: #808695;
    }
  }
.app-main {
  /* 50= navbar  50  */
  min-height: calc(100vh - 50px);
  width: 100%;
  position: relative;
  overflow: hidden;
}

.fixed-header+.app-main {
  padding-top: 50px;
}

.hasTagsView {
  .app-main {
    background: #f5f5f5;
    /* 84 = navbar + tags-view = 50 + 34 */
    min-height: calc(100vh - 84px);
    overflow-y: scroll;
  }

  .fixed-header+.app-main {
    padding-top: 80px;
  }
}
.el-popup-parent--hidden {
  .fixed-header {
    padding-right: 15px;
  }
}
</style>

