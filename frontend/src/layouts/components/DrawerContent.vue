<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '작가 관리' }" />
        <VerticalNavLink
            :item="{
                title: '작가',
                to: '/authors',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '출판관리',
                to: '/publishManages',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '구독자 관리' }" />
        <VerticalNavLink
            :item="{
                title: '구독자',
                to: '/subscribers',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '서비스' }" />
        <VerticalNavLink
            :item="{
                title: '서비스',
                to: '/services',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '관리자' }" />
        <VerticalNavLink
            :item="{
                title: '관리자',
                to: '/admins',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '대시보드' }" />
        <VerticalNavLink
            :item="{
                title: '책 조회',
                to: '/bookLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '구독상태조회',
                to: '/구독상태조회',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '베스트셀러조회',
                to: '/bestsellerLists',
            }"
        />
    </ul>
</template>
