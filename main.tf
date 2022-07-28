terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 3.49"
    }
  }

  required_version = ">= 0.14.9"
}

provider "aws" {
  profile = "local"
  region = var.aws_region
  access_key = "mock_access_key"
  s3_force_path_style = true
  secret_key = "mock_secret_key"
  skip_credentials_validation = true
  skip_metadata_api_check = true
  skip_requesting_account_id = true

  endpoints {
    sqs = "http://localhost:4566"
  }
}

variable "aws_region" {
  type = string
  default = "eu-central-1"
}

resource "aws_sqs_queue" "userEventsQueue" {
  name = "userQueue"
  visibility_timeout_seconds = 30
  message_retention_seconds = 86400
}

resource "aws_sqs_queue" "emailEventsQueue" {
  name = "emailQueue"
  visibility_timeout_seconds = 30
  message_retention_seconds = 86400
}

resource "aws_sqs_queue" "commentEventsQueue" {
  name = "commentQueue"
  visibility_timeout_seconds = 30
  message_retention_seconds = 86400
}

resource "aws_sqs_queue" "articleEventsQueue" {
  name = "articleQueue"
  visibility_timeout_seconds = 30
  message_retention_seconds = 86400
}